package org.example.delete.back.service;

import org.example.delete.back.dto.request.SaveTimeTableRequest;
import org.example.delete.back.entity.TimeTable;
import org.example.delete.back.repository.TimeTableRepository;

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
