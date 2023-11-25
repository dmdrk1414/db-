package org.example.domain;

import com.sun.jdi.IntegerType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class AttendanceStatus {
    private final Integer id;
    private final String status;
    private final String attendanceTime;
    private final String attendanceDate;

    public AttendanceStatus(Integer id, String status, String attendanceTime, String attendanceDate) {
        this.id = id;
        this.status = status;
        this.attendanceTime = attendanceTime;
        this.attendanceDate = attendanceDate;
    }
}
