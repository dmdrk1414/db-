package org.example.delete.back.repository;

import org.example.delete.back.database.DatabaseDelete;
import org.example.delete.back.domain.Application;
import org.example.delete.back.entity.WeekData;

import java.util.List;

public class WeekDataRepository {
    private final DatabaseDelete database;

    public WeekDataRepository() {
        this.database = new DatabaseDelete();
    }

    public List<WeekData> findAll() {
        return database.findAllWeekData();
    }

    public Boolean updateWeekDate(Integer memberId) {
        return database.updateWeekDate(memberId);
    }

    public boolean save(Application application) {
        return database.saveWeekDate(application);
    }
}
