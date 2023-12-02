package org.example.delete.front.constant;

import java.sql.*;

public class DBTableDelete {
    private Connection connection;
    private Statement statement;

    public DBTableDelete() {
        try {
            // Oracle 드라이버 로드
            this.connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "C##assignment4", "1234");
            this.statement = connection.createStatement();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] get(String table) {
        String sql = "SELECT * FROM " + table;

        try {
            ResultSet resultSetQuery = statement.executeQuery(sql);
            ResultSetMetaData metaData = resultSetQuery.getMetaData();
            Integer columnCount = metaData.getColumnCount();
            String[] dbColumnNames = new String[columnCount];

            for (int i = 1; i <= columnCount; i++) {
                // 컬럼 이름을 dbColumnNames에 추가.
                dbColumnNames[i - 1] = metaData.getColumnName(i);
            }

            return dbColumnNames;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
