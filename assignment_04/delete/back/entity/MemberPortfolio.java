package org.example.delete.back.entity;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString

public class MemberPortfolio {
    private static final Integer SIZE_COUNT = 5;

    private final Integer id;
    private final String motivationApplication;
    private final String gpa;
    private final String dream;
    private final Integer memberId;

    public String[] ofArray() {
        String[] array = new String[SIZE_COUNT];

        array[0] = String.valueOf(this.id);
        array[1] = this.motivationApplication;
        array[2] = this.gpa;
        array[3] = this.dream;
        array[4] = String.valueOf(this.memberId);

        return array;
    }
}
