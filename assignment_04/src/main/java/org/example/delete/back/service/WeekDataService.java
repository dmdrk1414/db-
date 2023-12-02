package org.example.delete.back.service;

import org.example.delete.back.domain.Application;
import org.example.delete.back.entity.WeekData;
import org.example.delete.back.repository.WeekDataRepository;

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
