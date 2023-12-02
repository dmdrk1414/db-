package org.example.delete.back.service;

import org.example.delete.back.entity.AttendanceStatus;
import org.example.delete.back.repository.AttendanceStatusRepository;
import org.example.delete.back.domain.Application;

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
