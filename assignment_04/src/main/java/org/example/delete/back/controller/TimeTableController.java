package org.example.delete.back.controller;

import org.example.delete.back.dto.request.DeleteTimeTableRequest;
import org.example.delete.back.service.TimeTableService;
import org.example.delete.back.dto.request.SaveTimeTableRequest;

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
