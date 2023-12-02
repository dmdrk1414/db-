package org.example.back.database;

import org.example.back.config.Config;
import org.example.back.constant.RowConstant;
import org.example.back.entity.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBStudent {
    private static final Integer STUDENT_ROW_COUNT = RowConstant.STUDENT.getRowCount();
    private final Statement statement;
    private final Connection connection;

    public DBStudent(Statement dbStatement, Connection connection) {
        this.statement = dbStatement;
        this.connection = connection;
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        Student student = null;

        try {
            String sql = "SELECT * FROM student"; // SQL 쿼리
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                List<String> rows = new ArrayList<>();

                for (int i = 1; i <= STUDENT_ROW_COUNT; i++) {
                    rows.add(resultSet.getString(i));
                }

                student = Config.getStudentFromRowArray(rows);
                students.add(student);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }
}
