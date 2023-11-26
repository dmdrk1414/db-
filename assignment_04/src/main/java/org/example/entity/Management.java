package org.example.entity;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString

public class Management {
    private final Integer id;
    private final String date;
    private final Integer vacationCount;
    private final Integer memberId;
}
