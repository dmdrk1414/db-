package org.example.database;

import org.example.config.Config;
import org.example.constant.RowCount;
import org.example.entity.WeekData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBWeekData {
    private static final Integer POST_WEEK_DATA_COUNT = RowCount.WEEK_DATA.getRowCount();
    private final Statement statement;

    public DBWeekData(Statement dbStatement) {
        this.statement = dbStatement;
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
}
