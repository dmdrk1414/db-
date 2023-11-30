package org.example.back.entity;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString

public class Management {
    private static final Integer SIZE_COUNT = 4;

    private final Integer id;
    private final String date;
    private final Integer vacationCount;
    private final Integer memberId;

    public String[] ofArray() {
        String[] array = new String[SIZE_COUNT];

        array[0] = String.valueOf(this.id);
        array[1] = this.date;
        array[2] = String.valueOf(this.vacationCount);
        array[3] = String.valueOf(this.memberId);

        return array;
    }
}
