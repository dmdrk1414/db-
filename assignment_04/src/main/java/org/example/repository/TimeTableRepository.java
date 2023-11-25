package org.example.repository;

import org.example.database.Database;
import org.example.domain.Post;
import org.example.domain.TimeTable;

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
