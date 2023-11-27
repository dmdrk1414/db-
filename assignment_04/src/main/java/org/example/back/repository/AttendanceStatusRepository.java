package org.example.back.repository;

import org.example.back.entity.AttendanceStatus;
import org.example.back.database.Database;
import org.example.back.domain.Application;

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
