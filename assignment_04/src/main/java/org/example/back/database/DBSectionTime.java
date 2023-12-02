package org.example.back.database;

import org.example.back.config.Config;
import org.example.back.constant.RowConstant;
import org.example.back.entity.SectionTime;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBSectionTime {
    private static final Integer SECTION_TIME_COUNT = RowConstant.SECTION_TIME.getRowCount();
    private final Statement statement;
    private final Connection connection;

    public DBSectionTime(Statement dbStatement, Connection connection) {
        this.statement = dbStatement;
        this.connection = connection;
    }

    public List<SectionTime> findAll() {
        List<SectionTime> sectionTimes = new ArrayList<>();
        SectionTime sectionTime = null;

        try {
            String sql = "SELECT * FROM section_time"; // SQL 쿼리
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                List<String> rows = new ArrayList<>();

                for (int i = 1; i <= SECTION_TIME_COUNT; i++) {
                    rows.add(resultSet.getString(i));
                }

                sectionTime = Config.getSectionTimeFromRowArray(rows);
                sectionTimes.add(sectionTime);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return sectionTimes;
    }
}
