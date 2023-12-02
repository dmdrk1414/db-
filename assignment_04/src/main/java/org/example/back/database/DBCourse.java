package org.example.back.database;

import org.example.back.config.Config;
import org.example.back.constant.RowConstant;
import org.example.back.entity.Course;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBCourse {
    private static final Integer COURSE_ROW_COUNT = RowConstant.COURSE.getRowCount();
    private final Statement statement;
    private final Connection connection;

    public DBCourse(Statement dbStatement, Connection connection) {
        this.statement = dbStatement;
        this.connection = connection;
    }

    public List<Course> findAll() {
        List<Course> courses = new ArrayList<>();
        Course course = null;

        try {
            String sql = "SELECT * FROM course"; // SQL 쿼리
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                List<String> rows = new ArrayList<>();

                for (int i = 1; i <= COURSE_ROW_COUNT; i++) {
                    rows.add(resultSet.getString(i));
                }

                course = Config.getCourceFromRowArray(rows);
                courses.add(course);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courses;
    }

}
