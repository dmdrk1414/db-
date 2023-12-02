package org.example.back.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Instructor {
    private final String id;
    private final String name;
    private final String office;
    private final String phone;
    private final String departmentName;
    private final String departmentCode;
    private final String collegeName;
    private final String chairStartDate;

    public String[] ofArray() {

        String[] array = new String[20];
        array[0] = this.id;
        array[1] = this.name;
        array[2] = this.office;
        array[3] = this.phone;
        array[4] = this.departmentName;
        array[5] = this.departmentCode;
        array[6] = this.collegeName;
        array[7] = this.chairStartDate;

        return array;
    }
}
