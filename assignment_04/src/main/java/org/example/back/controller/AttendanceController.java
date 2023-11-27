package org.example.back.controller;

import org.example.back.service.AttendanceStatusService;
import org.example.back.service.WeekDataService;
import org.example.back.dto.request.AttendanceRequest;

public class AttendanceController {
    private final AttendanceStatusService attendanceStatusService;
    private final WeekDataService weekDataService;

    public AttendanceController() {
        this.attendanceStatusService = new AttendanceStatusService();
        this.weekDataService = new WeekDataService();
    }

    public Boolean passAttendance(AttendanceRequest attendanceRequest) {
        if (isPassAttendance(attendanceRequest)) {
            weekDataService.updateWeekDate(attendanceRequest.getMemberId());
            return true;
        }
        return false;
    }

    private boolean isPassAttendance(AttendanceRequest attendanceRequest) {
        return attendanceRequest.getAttendenceNumber().trim() == "1234" &&
                attendanceStatusService.updateAttendanceStatus(attendanceRequest.getMemberId());
    }
}
