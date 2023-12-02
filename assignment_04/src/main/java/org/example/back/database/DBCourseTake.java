package org.example.back.database;

import org.example.back.config.Config;
import org.example.back.constant.RowConstant;
import org.example.back.entity.CourseTake;

import java.sql.*;
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

    public boolean save(String studentId, String courseName, String courseCode, String sectionDevisionNumber) {
        String sql = "INSERT INTO course_take (student_id, course_name, course_code, section_devision_number)" +
                " VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, studentId);
            preparedStatement.setString(2, courseName);
            preparedStatement.setString(3, courseCode);
            preparedStatement.setString(4, sectionDevisionNumber);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    public CourseTake findByStudentId(String studentId) {
        CourseTake courseTake = null;

        try {
            String sql = "SELECT * FROM course_take WHERE student_id=" + studentId; // SQL 쿼리
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                List<String> rows = new ArrayList<>();

                for (int i = 1; i <= COURSE_ROW_COUNT; i++) {
                    rows.add(resultSet.getString(i));
                }

                courseTake = Config.getCourceTakeFromRowArray(rows);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return courseTake;
    }
}
