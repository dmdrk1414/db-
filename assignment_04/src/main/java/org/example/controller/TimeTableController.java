package org.example.controller;

import org.example.dto.request.DeleteTimeTableRequest;
import org.example.dto.request.SaveTimeTableRequest;
import org.example.service.TimeTableService;

public class TimeTableController {
    private TimeTableService timeTableService;

    public TimeTableController() {
        this.timeTableService = new TimeTableService();
    }

    public Boolean saveTimeTable(SaveTimeTableRequest saveTimeTableRequest) {
        if (timeTableService.save(saveTimeTableRequest)) {
            return true;
        }
        return false;
    }

    public Boolean deleteTimeTableById(DeleteTimeTableRequest deleteTimeTableRequest) {
        if (timeTableService.deleteById(deleteTimeTableRequest.getId())) {
            return true;
        }
        return false;
    }
}
