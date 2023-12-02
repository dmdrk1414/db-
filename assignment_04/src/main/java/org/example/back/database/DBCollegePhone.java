package org.example.back.database;

import org.example.back.config.Config;
import org.example.back.constant.RowConstant;
import org.example.back.entity.CollegePhone;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBCollegePhone {
    private static final Integer COLLEGE_PHONE_ROW_COUNT = RowConstant.COLLEGE_PHONE.getRowCount();
    private final Statement statement;
    private final Connection connection;

    public DBCollegePhone(Statement dbStatement, Connection connection) {
        this.statement = dbStatement;
        this.connection = connection;
    }

    public List<CollegePhone> findAll() {
        List<CollegePhone> collegePhones = new ArrayList<>();
        CollegePhone collegePhone = null;

        try {
            String sql = "SELECT * FROM college_phone"; // SQL 쿼리
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                List<String> rows = new ArrayList<>();

                for (int i = 1; i <= COLLEGE_PHONE_ROW_COUNT; i++) {
                    rows.add(resultSet.getString(i));
                }

                collegePhone = Config.getCollegePhoneFromRowArray(rows);
                collegePhones.add(collegePhone);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return collegePhones;
    }
}
