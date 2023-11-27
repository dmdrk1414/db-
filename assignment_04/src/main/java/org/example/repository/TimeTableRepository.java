package org.example.repository;

import org.example.database.Database;
import org.example.dto.request.SaveTimeTableRequest;
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

    public boolean save(SaveTimeTableRequest saveTimeTableRequest) {
        return database.saveTimeTable(saveTimeTableRequest);
    }

    public boolean deleteById(Integer tableId) {
        return database.deleteById(tableId);
    }
}
