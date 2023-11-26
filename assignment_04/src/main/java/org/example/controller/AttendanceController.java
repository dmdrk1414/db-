package org.example.controller;

import org.example.dto.request.AttendanceRequest;
import org.example.service.AttendanceStatusService;

public class AttendanceController {
    private final AttendanceStatusService attendanceStatusService;

    public AttendanceController() {
        this.attendanceStatusService = new AttendanceStatusService();
    }

    public Boolean passAttendance(AttendanceRequest attendanceRequest) {
        if (isPassAttendance(attendanceRequest)) {
            return true;
        }
        return false;
    }

    private boolean isPassAttendance(AttendanceRequest attendanceRequest) {
        return attendanceRequest.getAttendenceNumber().trim() == "1234" &&
                attendanceStatusService.updateAttendanceStatus(attendanceRequest.getId());
    }
}
