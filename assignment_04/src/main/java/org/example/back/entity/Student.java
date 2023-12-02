package org.example.back.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Student {
    private final String id;
    private final String name;
    private final String address;
    private final String phone;
    private final String major;
    private final String departmentName;
    private final String departmentCode;

    public String[] ofArray() {

        String[] array = new String[20];
        array[0] = this.id;
        array[1] = this.name;
        array[2] = this.address;
        array[3] = this.phone;
        array[4] = this.major;
        array[5] = this.departmentName;
        array[6] = this.departmentCode;

        return array;
    }
}
