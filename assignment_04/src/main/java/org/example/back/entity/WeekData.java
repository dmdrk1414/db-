package org.example.back.entity;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString

public class WeekData {
    private static final Integer SIZE_COUNT = 5;

    private final Boolean monday;
    private final Boolean tuesday;
    private final Boolean wednesday;
    private final Boolean thursday;
    private final Boolean friday;
    private final Integer managementId;
    private final Integer memberId;


    public String[] ofArray() {
        String[] array = new String[SIZE_COUNT];

        array[0] = String.valueOf(this.monday);
        array[1] = String.valueOf(this.tuesday);
        array[2] = String.valueOf(this.wednesday);
        array[3] = String.valueOf(this.thursday);
        array[4] = String.valueOf(this.friday);
        array[5] = String.valueOf(this.managementId);
        array[6] = String.valueOf(this.memberId);

        return array;
    }
}
