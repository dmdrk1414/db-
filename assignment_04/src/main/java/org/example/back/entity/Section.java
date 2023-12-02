package org.example.back.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Section {
    private final String id;
    private final String devisionNumber;
    private final String month;
    private final String year;
    private final String day;
    private final String instructorId;
    private final String courseCode;
    private final String courseName;
    private final String roomNumber;
    private final String building;

    public String[] ofArray() {

        String[] array = new String[20];
        array[0] = this.id;
        array[1] = this.devisionNumber;
        array[2] = this.month;
        array[3] = this.year;
        array[4] = this.day;
        array[5] = this.instructorId;
        array[6] = this.courseCode;
        array[7] = this.courseName;
        array[8] = this.roomNumber;
        array[9] = this.building;

        return array;
    }
}
