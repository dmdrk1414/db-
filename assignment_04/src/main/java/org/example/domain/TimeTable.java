package org.example.domain;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class TimeTable {
    private final Integer id;
    private final String image;
    private final String applyDate;
    private final Integer memberId;
}
