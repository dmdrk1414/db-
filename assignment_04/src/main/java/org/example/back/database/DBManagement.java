package org.example.back.database;

import org.example.back.config.Config;
import org.example.back.constant.RowCount;
import org.example.back.entity.Management;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBManagement {
    private static final Integer MANAGEMENT_ROW_COUNT = RowCount.MANAGEMENT.getRowCount();
    private final Statement statement;

    public DBManagement(Statement dbStatement) {
        this.statement = dbStatement;
    }

    public List<Management> findAll() {
        List<Management> managements = new ArrayList<>();
        Management management = null;

        try {
            String sql = "SELECT * FROM management"; // SQL 쿼리
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                List<String> rows = new ArrayList<>();

                for (int i = 1; i <= MANAGEMENT_ROW_COUNT; i++) {
                    rows.add(resultSet.getString(i));
                }

                management = Config.getManagementFromRowArray(rows);
                managements.add(management);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return managements;
    }
}
