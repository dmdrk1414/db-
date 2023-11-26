package org.example.database;

import org.example.config.Config;
import org.example.constant.ConstantAttendanceState;
import org.example.constant.RowCount;
import org.example.entity.WeekData;

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
}
