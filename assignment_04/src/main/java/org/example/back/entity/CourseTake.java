package org.example.back.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class CourseTake {
    private final String id;
    private final String studentId;
    private final String courseName;
    private final String courseCode;
    private final String sectionDevisionNumber;

    public String[] ofArray() {
        String[] array = new String[20];
        array[0] = this.id;
        array[1] = this.studentId;
        array[2] = this.courseName;
        array[3] = this.courseCode;
        array[4] = this.sectionDevisionNumber;

        return array;
    }
}
