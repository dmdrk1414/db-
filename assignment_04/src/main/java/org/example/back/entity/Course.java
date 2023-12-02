package org.example.back.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Course {
    private final String code;
    private final String name;
    private final String credits;
    private final String courseLevel;
    private final String description;
    private final String departmentName;
    private final String departmentCode;

    public String[] ofArray() {
        String[] array = new String[20];
        array[0] = this.code;
        array[1] = this.name;
        array[2] = this.credits;
        array[3] = this.courseLevel;
        array[4] = this.description;
        array[5] = this.departmentName;
        array[6] = this.departmentCode;

        return array;
    }
}
