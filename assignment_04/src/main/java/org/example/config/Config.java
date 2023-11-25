package org.example.config;

import org.example.domain.AttendanceStatus;

import java.util.List;

public class Config {
    public static AttendanceStatus getAttendanceStatus(List<String> rows) {
        AttendanceStatus attendanceStatus;
        attendanceStatus = AttendanceStatus.builder()
                .id(Integer.valueOf(rows.get(0)))
                .status(rows.get(1))
                .attendanceTime(rows.get(2))
                .attendanceDate(rows.get(3))
                .memberId(Integer.valueOf(rows.get(4)))
                .build();
        return attendanceStatus;
    }
}
