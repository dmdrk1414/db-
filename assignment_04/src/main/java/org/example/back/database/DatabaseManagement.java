package org.example.back.database;

import lombok.Getter;
import org.example.back.entity.College;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

@Getter
public class DatabaseManagement {
    private final Statement dbStatement;
    private final Connection connection;

    public DatabaseManagement() {
        DBConnection dbConnection = new DBConnection();
        this.dbStatement = dbConnection.getStatement();
        this.connection = dbConnection.getConnection();
    }

    public List<College> findAllCollege() {
        return new DBCollege(dbStatement, connection).findAll();
    }
}