package org.example.back.database;

import org.example.back.config.Config;
import org.example.back.constant.RowConstant;
import org.example.back.entity.Department;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBDepartment {
    private static final Integer COLLEGE_ROW_COUNT = RowConstant.DEPARTMENT.getRowCount();
    private final Statement statement;
    private final Connection connection;

    public DBDepartment(Statement dbStatement, Connection connection) {
        this.statement = dbStatement;
        this.connection = connection;
    }

    public List<Department> findAll() {
        List<Department> departments = new ArrayList<>();
        Department department = null;

        try {
            String sql = "SELECT * FROM department"; // SQL 쿼리
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                List<String> rows = new ArrayList<>();

                for (int i = 1; i <= COLLEGE_ROW_COUNT; i++) {
                    rows.add(resultSet.getString(i));
                }

                department = Config.getDepartmentFromRowArray(rows);
                departments.add(department);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return departments;
    }
}
