package org.example.delete.back.entity;

import com.sun.jdi.IntegerType;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString
public class AttendanceStatus {
    private static final Integer SIZE_COUNT = 5;

    private final Integer id;
    private final String status;
    private final String attendanceTime;
    private final String attendanceDate;
    private final Integer memberId;

    public String[] ofArray() {
        String[] array = new String[SIZE_COUNT];

        array[0] = String.valueOf(this.id);
        array[1] = this.status;
        array[2] = this.attendanceTime;
        array[3] = this.attendanceDate;
        array[4] = String.valueOf(this.memberId);

        return array;
    }
}
