package org.example.database;

import org.example.config.Config;
import org.example.constant.RowCount;
import org.example.domain.Post;
import org.example.domain.TimeTable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBTimeTable {
    private static final Integer POST_TIME_TABLE_COUNT = RowCount.TIME_TABLE.getRowCount();
    private final Statement statement;

    public DBTimeTable(Statement dbStatement) {
        this.statement = dbStatement;
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
}
