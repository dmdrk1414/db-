package org.example.delete.back.repository;

import org.example.delete.back.database.DatabaseDelete;
import org.example.delete.back.domain.Application;
import org.example.delete.back.entity.Management;

import java.util.List;

public class ManagementRepository {
    private final DatabaseDelete database;

    public ManagementRepository() {
        this.database = new DatabaseDelete();
    }

    public List<Management> findAll() {
        return database.findAllManagement();
    }

    public boolean save(Application application) {
        return database.saveManagement(application);
    }
}
