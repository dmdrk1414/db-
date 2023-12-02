package org.example.back.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class InstructorRank {
    private final String instructorId;
    private final String rank;

    public String[] ofArray() {

        String[] array = new String[20];
        array[0] = this.instructorId;
        array[1] = this.rank;

        return array;
    }
}
