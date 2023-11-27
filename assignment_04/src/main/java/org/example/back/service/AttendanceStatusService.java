package org.example.back.service;

import org.example.back.entity.AttendanceStatus;
import org.example.back.repository.AttendanceStatusRepository;
import org.example.back.domain.Application;

import java.util.List;

public class AttendanceStatusService {
    private final AttendanceStatusRepository attendanceStatusRepository;

    public AttendanceStatusService() {
        this.attendanceStatusRepository = new AttendanceStatusRepository();
    }

    public List<AttendanceStatus> findAll() {
        return attendanceStatusRepository.findAll();
    }

    public boolean save(Application application) {
        return attendanceStatusRepository.save(application);
    }

    public boolean updateAttendanceStatus(Integer memberId) {
        return attendanceStatusRepository.updateAttendanceStatus(memberId);
    }
}
