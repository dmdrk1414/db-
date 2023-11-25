package org.example.domain;

import com.sun.jdi.IntegerType;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
public class AttendanceStatus {
    private final Integer id;
    private final String status;
    private final String attendanceTime;
    private final String attendanceDate;
    private final Integer memberId;
}
