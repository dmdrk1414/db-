package org.example.back.database;

import org.example.back.config.Config;
import org.example.back.constant.RowCount;
import org.example.back.domain.Application;
import org.example.back.entity.Member;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBMember {
    private static final Integer MEMBER_ROW_COUNT = RowCount.MEMBER.getRowCount();
    private final Statement statement;
    private final Connection connection;

    public DBMember(Statement dbStatement, Connection connection) {
        this.statement = dbStatement;
        this.connection = connection;
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

    public Boolean save(Application application) {
        String sql = "INSERT INTO member (name, email, password, grade, phone_number)" +
                " VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, application.getName());
            preparedStatement.setString(2, application.getEmail());
            preparedStatement.setString(3, application.getPassword());
            preparedStatement.setString(4, application.getGrade());
            preparedStatement.setString(5, application.getPhoneNumber());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public Member findByEmail(String email) {
        Member member = null;
        String sql = "SELECT * FROM member WHERE email = ?";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, email);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // ResultSet에서 데이터를 읽어와 Member 객체를 생성하거나 반환 로직 추가
                    member = Member.builder()
                            .id(resultSet.getInt("id"))
                            .name(resultSet.getString("name"))
                            .email(resultSet.getString("email"))
                            .password(resultSet.getString("password"))
                            .phonNumber(resultSet.getString("phone_number"))
                            .build();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve member by email", e);
        }

        return member;
    }
}
