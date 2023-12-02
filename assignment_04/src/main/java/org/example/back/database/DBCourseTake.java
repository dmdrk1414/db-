package org.example.back.database;

import org.example.back.config.Config;
import org.example.back.constant.RowConstant;
import org.example.back.entity.CourseTake;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBCourseTake {
    private static final Integer COURSE_ROW_COUNT = RowConstant.COURSE_TAKE.getRowCount();
    private final Statement statement;
    private final Connection connection;

    public DBCourseTake(Statement dbStatement, Connection connection) {
        this.statement = dbStatement;
        this.connection = connection;
    }

    public List<CourseTake> findAll() {
        List<CourseTake> courseTakes = new ArrayList<>();
        CourseTake courseTake = null;

        try {
            String sql = "SELECT * FROM course_take"; // SQL 쿼리
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                List<String> rows = new ArrayList<>();

                for (int i = 1; i <= COURSE_ROW_COUNT; i++) {
                    rows.add(resultSet.getString(i));
                }

                courseTake = Config.getCourceTakeFromRowArray(rows);
                courseTakes.add(courseTake);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courseTakes;
    }
}
