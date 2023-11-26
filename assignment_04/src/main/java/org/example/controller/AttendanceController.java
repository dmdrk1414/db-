package org.example.controller;

import org.example.dto.request.AttendanceRequest;
import org.example.service.AttendanceStatusService;
import org.example.service.WeekDataService;

public class AttendanceController {
    private final AttendanceStatusService attendanceStatusService;
    private final WeekDataService weekDataService;

    public AttendanceController() {
        this.attendanceStatusService = new AttendanceStatusService();
        this.weekDataService = new WeekDataService();
    }

    public Boolean passAttendance(AttendanceRequest attendanceRequest) {
        if (isPassAttendance(attendanceRequest)) {
            weekDataService.updateWeekDate(attendanceRequest.getId());
            return true;
        }
        return false;
    }

    private boolean isPassAttendance(AttendanceRequest attendanceRequest) {
        return attendanceRequest.getAttendenceNumber().trim() == "1234" &&
                attendanceStatusService.updateAttendanceStatus(attendanceRequest.getId());
    }
}
