package org.example.back.entity;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString

public class WeekData {
    private final Boolean monday;
    private final Boolean tuesday;
    private final Boolean wednesday;
    private final Boolean thursday;
    private final Boolean friday;
    private final Integer managementId;
    private final Integer memberId;
}
