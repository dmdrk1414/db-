package org.example.back.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Department {
    private final String code;
    private final String name;
    private final String office;
    private final String phone;
    private final String collegeName;

    public String[] ofArray() {
        String[] array = new String[20];
        array[0] = this.code;
        array[1] = this.name;
        array[2] = this.office;
        array[3] = this.phone;
        array[4] = this.collegeName;

        return array;
    }
}
