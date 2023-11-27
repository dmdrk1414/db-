package org.example.back.repository;

import org.example.back.entity.WeekData;
import org.example.back.database.Database;

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
