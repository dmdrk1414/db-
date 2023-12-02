package org.example.delete.back.repository;

import org.example.delete.back.entity.AttendanceStatus;
import org.example.delete.back.database.Database;
import org.example.delete.back.domain.Application;

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

    public boolean updateAttendanceStatus(Integer memberId) {
        return database.updateAttendanceStatus(memberId);
    }
}
