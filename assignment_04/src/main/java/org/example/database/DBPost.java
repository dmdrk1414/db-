package org.example.database;

import org.example.config.Config;
import org.example.constant.RowCount;
import org.example.domain.MemberPortfolio;
import org.example.domain.Post;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBPost {
    private static final Integer POST_ROW_COUNT = RowCount.POST.getRowCount();
    private final Statement statement;

    public DBPost(Statement dbStatement) {
        this.statement = dbStatement;
    }

    public List<Post> findAll() {
        // 수정
        List<Post> posts = new ArrayList<>();
        Post post = null;

        try {
            // 수정
            String sql = "SELECT * FROM post"; // SQL 쿼리
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                List<String> rows = new ArrayList<>();

                for (int i = 1; i <= POST_ROW_COUNT; i++) {
                    rows.add(resultSet.getString(i));
                }

                post = Config.getPostFromRowArray(rows);
                posts.add(post);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return posts;
    }
}
