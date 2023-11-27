package org.example.back.repository;

import org.example.back.domain.Application;
import org.example.back.entity.Management;
import org.example.back.database.Database;

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
