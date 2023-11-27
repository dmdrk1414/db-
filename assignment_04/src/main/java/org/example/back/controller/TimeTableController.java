package org.example.back.controller;

import org.example.back.dto.request.DeleteTimeTableRequest;
import org.example.back.service.TimeTableService;
import org.example.back.dto.request.SaveTimeTableRequest;

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
        if (timeTableService.deleteById(deleteTimeTableRequest.getTableId())) {
            return true;
        }
        return false;
    }
}
