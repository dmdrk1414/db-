package org.example.back.database;

import org.example.back.config.Config;
import org.example.back.constant.RowConstant;
import org.example.back.entity.Instructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBInstructor {
    private static final Integer COLLEGE_ROW_COUNT = RowConstant.INSTRUCTOR.getRowCount();
    private final Statement statement;
    private final Connection connection;

    public DBInstructor(Statement dbStatement, Connection connection) {
        this.statement = dbStatement;
        this.connection = connection;
    }

    public List<Instructor> findAll() {
        List<Instructor> instructors = new ArrayList<>();
        Instructor instructor = null;

        try {
            String sql = "SELECT * FROM instructor"; // SQL 쿼리
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                List<String> rows = new ArrayList<>();

                for (int i = 1; i <= COLLEGE_ROW_COUNT; i++) {
                    rows.add(resultSet.getString(i));
                }

                instructor = Config.getInstructorFromRowArray(rows);
                instructors.add(instructor);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return instructors;
    }
}
