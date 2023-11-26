package org.example.service;

import org.example.entity.WeekData;
import org.example.repository.WeekDataRepository;

import java.util.List;

public class WeekDataService {
    private final WeekDataRepository weekDataRepository;

    public WeekDataService() {
        this.weekDataRepository = new WeekDataRepository();
    }

    public List<WeekData> findAll() {
        return weekDataRepository.findAll();
    }

    public Boolean updateWeekDate(Integer memberId) {
        return weekDataRepository.updateWeekDate(memberId);
    }
}
