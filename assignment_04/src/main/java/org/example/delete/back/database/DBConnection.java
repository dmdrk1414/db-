package org.example.delete.back.database;

import lombok.Getter;

import java.sql.*;

@Getter
public class DBConnection {
    // 데이터베이스 연결을 위한 클래스
    private static final String ORACLE_JDBC_URL = "jdbc:oracle:thin:@localhost:1521:orcl";
    private static final String ORACLE_DATABASE_ID = "C##assignment4";
    private static final String ORACLE_DATABASE_PASSWORD = "1234";
    private Statement statement; // Statement 객체
    private Connection connection;

    // DBConnectionTest 생성자
    public DBConnection() {
        try {
            // Oracle 드라이버 로드
            Class.forName("oracle.jdbc.OracleDriver");
            // 데이터베이스 연결
            // Connection 객체
            connection = DriverManager.getConnection(ORACLE_JDBC_URL, ORACLE_DATABASE_ID, ORACLE_DATABASE_PASSWORD);

            statement = connection.createStatement(); // Statement 객체 생성
        } catch (ClassNotFoundException e) {
            System.out.println("해당 드라이버를 찾을 수 없습니다.\n" + e);
        } catch (SQLException e) {
            System.out.println("데이터베이스 연결 중 오류가 발생했습니다.\n" + e);
        }
    }
}
