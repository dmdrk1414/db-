package org.example.back.repository;

import org.example.back.entity.TimeTable;
import org.example.back.database.Database;
import org.example.back.dto.request.SaveTimeTableRequest;

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
