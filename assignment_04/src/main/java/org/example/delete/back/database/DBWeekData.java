package org.example.delete.back.database;

import org.example.delete.back.config.Config;
import org.example.delete.back.constant.RowCount;
import org.example.delete.back.domain.Application;
import org.example.delete.back.entity.WeekData;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBWeekData {
    private static final Integer POST_WEEK_DATA_COUNT = RowCount.WEEK_DATA.getRowCount();
    private final Statement statement;
    private final Connection connection;

    public DBWeekData(Statement dbStatement, Connection connection) {
        this.statement = dbStatement;
        this.connection = connection;
    }

    public List<WeekData> findAll() {
        // 수정
        List<WeekData> weekDatas = new ArrayList<>();
        WeekData weekData = null;

        try {
            // 수정
            String sql = "SELECT * FROM week_data"; // SQL 쿼리
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                List<String> rows = new ArrayList<>();

                for (int i = 1; i <= POST_WEEK_DATA_COUNT; i++) {
                    rows.add(resultSet.getString(i));
                }

                weekData = Config.getWeekDataFromRowArray(rows);
                weekDatas.add(weekData);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return weekDatas;
    }

    public Boolean updateWeekDate(Integer memberId) {
        // TODO: 2023-11-26 오늘 일자로 치환
        String sql = "UPDATE week_data SET monday = ? WHERE member_id = " + memberId;
        Integer passAttendance = 1;

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setInt(1, passAttendance);
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve member by email", e);
        }
    }

    public boolean save(Application application) {
        String sql = "INSERT INTO week_data (monday, tuesday, wednesday, thursday, friday, management_id, member_id)" +
                " VALUES (0, 0, 0, 0, 0, ?, ?)";
        Integer memberId = findMemberId(application.getEmail());
        Integer managementId = findManageMentId(memberId);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, managementId);
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

    private Integer findManageMentId(Integer memberId) {
        String sql = "SELECT * FROM management WHERE member_id = ?";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, String.valueOf(memberId));

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
