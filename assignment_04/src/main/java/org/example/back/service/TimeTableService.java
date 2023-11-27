package org.example.back.service;

import org.example.back.dto.request.SaveTimeTableRequest;
import org.example.back.entity.TimeTable;
import org.example.back.repository.TimeTableRepository;

import java.util.List;

public class TimeTableService {
    private final TimeTableRepository timeTableRepository;

    public TimeTableService() {
        this.timeTableRepository = new TimeTableRepository();
    }

    public List<TimeTable> findAll() {
        return timeTableRepository.findAll();
    }

    public boolean save(SaveTimeTableRequest saveTimeTableRequest) {
        return timeTableRepository.save(saveTimeTableRequest);
    }

    public boolean deleteById(Integer tableId) {
        return timeTableRepository.deleteById(tableId);
    }
}
