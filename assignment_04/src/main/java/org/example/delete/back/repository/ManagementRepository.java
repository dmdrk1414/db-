package org.example.delete.back.repository;

import org.example.delete.back.domain.Application;
import org.example.delete.back.entity.Management;
import org.example.delete.back.database.Database;

import java.util.List;

public class ManagementRepository {
    private final Database database;

    public ManagementRepository() {
        this.database = new Database();
    }

    public List<Management> findAll() {
        return database.findAllManagement();
    }

    public boolean save(Application application) {
        return database.saveManagement(application);
    }
}
