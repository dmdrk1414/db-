package org.example.service;

import org.example.entity.TimeTable;
import org.example.repository.TimeTableRepository;

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
