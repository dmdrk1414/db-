package org.example.service;

import org.example.domain.TimeTable;
import org.example.repository.TimeTableRepository;

import java.sql.Time;
import java.util.List;

public class TimeTableService {
    private final TimeTableRepository timeTableRepository;

    public TimeTableService() {
        this.timeTableRepository = new TimeTableRepository();
    }

    public List<TimeTable> findAll() {
        return timeTableRepository.findAll();
    }
}
