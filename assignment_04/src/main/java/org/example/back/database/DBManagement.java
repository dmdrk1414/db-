package org.example.back.database;

import org.example.back.config.Config;
import org.example.back.constant.RowCount;
import org.example.back.domain.Application;
import org.example.back.entity.Management;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBManagement {
    private static final Integer MANAGEMENT_ROW_COUNT = RowCount.MANAGEMENT.getRowCount();
    private static final Integer BASE_VACATION_COUNT = 5;
    private final Statement statement;
    private final Connection connection;

    public DBManagement(Statement dbStatement, Connection connection) {
        this.statement = dbStatement;
        this.connection = connection;
    }

    public List<Management> findAll() {
        List<Management> managements = new ArrayList<>();
        Management management = null;

        try {
            String sql = "SELECT * FROM management"; // SQL 쿼리
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                List<String> rows = new ArrayList<>();

                for (int i = 1; i <= MANAGEMENT_ROW_COUNT; i++) {
                    rows.add(resultSet.getString(i));
                }

                management = Config.getManagementFromRowArray(rows);
                managements.add(management);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return managements;
    }

    public boolean save(Application application) {
        String sql = "INSERT INTO management (renewal_date, vacation_count, member_id)" +
                " VALUES (SYSDATE, ?, ? )";
        Integer memberId = findMemberId(application.getEmail());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, BASE_VACATION_COUNT);
            preparedStatement.setInt(2, memberId);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    private Integer findMemberId(String email) {
        String sql = "SELECT * FROM member WHERE email = ?";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, String.valueOf(email));

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // ResultSet에서 데이터를 읽어와 Member 객체를 생성하거나 반환 로직 추가
                    return resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve member by email", e);
        }

        return null;
    }
}
