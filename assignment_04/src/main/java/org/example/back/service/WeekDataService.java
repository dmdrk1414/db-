package org.example.back.service;

import org.example.back.domain.Application;
import org.example.back.entity.WeekData;
import org.example.back.repository.WeekDataRepository;

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

    public boolean save(Application application) {
        return weekDataRepository.save(application);
    }
}
