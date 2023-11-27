package org.example.database;

import org.example.config.Config;
import org.example.constant.RowCount;
import org.example.dto.request.SavePostRequest;
import org.example.entity.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBPost {
    private static final Integer POST_ROW_COUNT = RowCount.POST.getRowCount();
    private final Statement statement;
    private final Connection connection;

    public DBPost(Statement dbStatement, Connection connection) {
        this.statement = dbStatement;
        this.connection = connection;
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

    public boolean save(SavePostRequest savePostRequest) {
        String sql = "INSERT INTO post (title, content, post_date, name, member_id)" +
                " VALUES (?, ?, SYSDATE, ?, ? )";
        String name = findMemberName(savePostRequest.getId());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, savePostRequest.getTitle());
            preparedStatement.setString(2, savePostRequest.getContent());
            preparedStatement.setString(3, name);
            preparedStatement.setInt(4, savePostRequest.getId());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public boolean deleteByPostId(Integer postId) {
        String sql = "DELETE FROM post WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, postId);

            Integer affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    private String findMemberName(Integer memberId) {
        String sql = "SELECT * FROM member WHERE id = ?";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, String.valueOf(memberId));

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // ResultSet에서 데이터를 읽어와 Member 객체를 생성하거나 반환 로직 추가
                    return resultSet.getString("name");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve member by email", e);
        }

        return null;
    }
}
