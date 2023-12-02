package org.example.back.database;

import lombok.Getter;
import org.example.back.entity.College;
import org.example.back.entity.CollegePhone;
import org.example.back.entity.Department;
import org.example.back.entity.Instructor;

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

    public List<CollegePhone> findAllCollegePhone() {
        return new DBCollegePhone(dbStatement, connection).findAll();
    }

    public List<Department> findALlDepartment() {
        return new DBDepartment(dbStatement, connection).findAll();
    }

    public List<Instructor> findAllInstructor() {
        return new DBInstructor(dbStatement, connection).findAll();
    }
}