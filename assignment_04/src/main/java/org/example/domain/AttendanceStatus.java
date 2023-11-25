package org.example.domain;

import com.sun.jdi.IntegerType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class AttendanceStatus {
    private final Integer id;
    private final String status;
    private final String attendanceTime;
    private final String attendanceDate;
    private final Integer memberId;
}
