package org.example.service;

import org.example.domain.AttendanceStatus;
import org.example.repository.AttendanceStatusRepository;

import java.util.List;

public class AttendanceStatusService {
    private final AttendanceStatusRepository attendanceStatusRepository;

    public AttendanceStatusService() {
        this.attendanceStatusRepository = new AttendanceStatusRepository();
    }

    public List<AttendanceStatus> findAll() {
        return attendanceStatusRepository.findAll();
    }
}
