package org.example.config;

import org.example.domain.AttendanceStatus;
import org.example.domain.Management;

import java.util.List;

public class Config {
    public static AttendanceStatus getAttendanceStatusFromRowArray(List<String> rows) {
        return AttendanceStatus.builder()
                .id(Integer.valueOf(rows.get(0)))
                .status(rows.get(1))
                .attendanceTime(rows.get(2))
                .attendanceDate(rows.get(3))
                .memberId(Integer.valueOf(rows.get(4)))
                .build();
    }

    public static Management getManagementFromRowArray(List<String> rows) {
        return Management.builder()
                .id(Integer.valueOf(rows.get(0)))
                .date(rows.get(1))
                .vacationCount(Integer.valueOf(rows.get(2)))
                .memberId(Integer.valueOf(rows.get(3)))
                .build();
    }
}
