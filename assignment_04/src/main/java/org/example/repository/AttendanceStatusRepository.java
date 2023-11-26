package org.example.repository;

import org.example.database.Database;
import org.example.domain.Application;
import org.example.entity.AttendanceStatus;

import java.util.List;

public class AttendanceStatusRepository {
    private final Database database;

    public AttendanceStatusRepository() {
        this.database = new Database();
    }

    public List<AttendanceStatus> findAll() {
        return database.findAllAttendanceStatus();
    }

    public boolean save(Application application) {
        return database.saveAttendanceStatus(application);
    }
}
