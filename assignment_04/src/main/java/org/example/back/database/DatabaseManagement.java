package org.example.back.database;

import lombok.Getter;

import java.sql.Connection;
import java.sql.Statement;

@Getter
public class DatabaseManagement {
    private final Statement dbStatement;
    private final Connection connection;

    public DatabaseManagement() {
        DBConnection dbConnection = new DBConnection();
        this.dbStatement = dbConnection.getStatement();
        this.connection = dbConnection.getConnection();
    }
}