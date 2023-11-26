package org.example.database;

import org.example.config.Config;
import org.example.constant.RowCount;
import org.example.entity.Member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBMember {
    private static final Integer MEMBER_ROW_COUNT = RowCount.MEMBER.getRowCount();
    private final Statement statement;

    public DBMember(Statement dbStatement) {
        this.statement = dbStatement;
    }

    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        Member member = null;

        try {
            String sql = "SELECT * FROM member"; // SQL 쿼리
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                List<String> rows = new ArrayList<>();

                for (int i = 1; i <= MEMBER_ROW_COUNT; i++) {
                    rows.add(resultSet.getString(i));
                }

                member = Config.getMemberFromRowArray(rows);
                members.add(member);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return members;
    }
}
