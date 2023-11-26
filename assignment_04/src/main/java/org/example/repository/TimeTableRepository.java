package org.example.repository;

import org.example.database.Database;
import org.example.entity.TimeTable;

import java.util.List;

public class TimeTableRepository {
    private final Database database;

    public TimeTableRepository() {
        this.database = new Database();
    }

    public List<TimeTable> findAll() {
        return database.findAllTimeTable();
    }
}
