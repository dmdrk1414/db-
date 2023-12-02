package org.example.back.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class CollegePhone {
    private final String id;
    private final String phone;
    private final String collegeName;

    public String[] ofArray() {
        String[] array = new String[20];
        array[0] = this.id;
        array[1] = this.phone;
        array[2] = this.collegeName;

        return array;
    }
}
