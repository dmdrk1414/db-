package org.example.repository;

import org.example.database.Database;
import org.example.entity.WeekData;

import java.util.List;

public class WeekDataRepository {
    private final Database database;

    public WeekDataRepository() {
        this.database = new Database();
    }

    public List<WeekData> findAll() {
        return database.findAllWeekData();
    }

    public Boolean updateWeekDate(Integer memberId) {
        return database.updateWeekDate(memberId);
    }
}
