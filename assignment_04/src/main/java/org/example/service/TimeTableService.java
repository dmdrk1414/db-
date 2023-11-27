package org.example.service;

import org.example.dto.request.SaveTimeTableRequest;
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

    public boolean save(SaveTimeTableRequest saveTimeTableRequest) {
        return timeTableRepository.save(saveTimeTableRequest);
    }

    public boolean deleteById(Integer id) {
        return timeTableRepository.deleteById(id);
    }
}
