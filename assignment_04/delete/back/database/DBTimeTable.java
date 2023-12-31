package org.example.delete.back.database;

import org.example.delete.back.config.Config;
import org.example.delete.back.constant.RowCount;
import org.example.delete.back.dto.request.SaveTimeTableRequest;
import org.example.delete.back.entity.TimeTable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBTimeTable {
    private static final Integer POST_TIME_TABLE_COUNT = RowCount.TIME_TABLE.getRowCount();
    private final Statement statement;
    private final Connection connection;

    public DBTimeTable(Statement dbStatement, Connection connection) {
        this.statement = dbStatement;
        this.connection = connection;
    }

    public List<TimeTable> findAll() {
        // 수정
        List<TimeTable> timeTables = new ArrayList<>();
        TimeTable timeTable = null;

        try {
            // 수정
            String sql = "SELECT * FROM time_table"; // SQL 쿼리
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                List<String> rows = new ArrayList<>();

                for (int i = 1; i <= POST_TIME_TABLE_COUNT; i++) {
                    rows.add(resultSet.getString(i));
                }

                timeTable = Config.getTimeTableFromRowArray(rows);
                timeTables.add(timeTable);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return timeTables;
    }

    public boolean save(SaveTimeTableRequest saveTimeTableRequest) {
        String sql = "INSERT INTO time_table (name, image, apply_date, member_id)" +
                " VALUES (?, ?, SYSDATE, ?)";
        String name = findMemberName(saveTimeTableRequest.getMemberId());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, saveTimeTableRequest.getImage());
            preparedStatement.setInt(3, saveTimeTableRequest.getMemberId());

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public boolean deleteById(Integer tableId) {
        String sql = "DELETE FROM time_table WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, tableId);

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
