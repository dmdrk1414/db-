package org.example.back.database;

import org.example.back.config.Config;
import org.example.back.constant.RowConstant;
import org.example.back.entity.College;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBCollege {
    private static final Integer COLLEGE_ROW_COUNT = RowConstant.COLLEGE.getRowCount();
    private final Statement statement;
    private final Connection connection;

    public DBCollege(Statement dbStatement, Connection connection) {
        this.statement = dbStatement;
        this.connection = connection;
    }

    public List<College> findAll() {
        List<College> colleges = new ArrayList<>();
        College college = null;

        try {
            String sql = "SELECT * FROM college"; // SQL 쿼리
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                List<String> rows = new ArrayList<>();

                for (int i = 1; i <= COLLEGE_ROW_COUNT; i++) {
                    rows.add(resultSet.getString(i));
                }

                college = Config.getCollegeFromRowArray(rows);
                colleges.add(college);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return colleges;
    }

}
