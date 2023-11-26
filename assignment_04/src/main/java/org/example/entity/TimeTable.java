package org.example.entity;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString

public class TimeTable {
    private final Integer id;
    private final String image;
    private final String applyDate;
    private final Integer memberId;
}
