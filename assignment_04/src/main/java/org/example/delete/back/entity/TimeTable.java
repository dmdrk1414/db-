package org.example.delete.back.entity;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString

public class TimeTable {
    private static final Integer SIZE_COUNT = 4;

    private final Integer id;
    private final String image;
    private final String applyDate;
    private final Integer memberId;

    public String[] ofArray() {
        String[] array = new String[SIZE_COUNT];

        array[0] = String.valueOf(this.id);
        array[1] = this.image;
        array[2] = this.applyDate;
        array[3] = String.valueOf(this.memberId);

        return array;
    }
}
