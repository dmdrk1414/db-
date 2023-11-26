package org.example.repository;

import org.example.database.Database;
import org.example.entity.Management;

import java.util.List;

public class ManagementRepository {
    private final Database database;

    public ManagementRepository() {
        this.database = new Database();
    }

    public List<Management> findAll() {
        return database.findAllManagement();
    }
}
