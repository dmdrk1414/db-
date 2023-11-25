package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class WeekData {
    private final Boolean monday;
    private final Boolean tuesday;
    private final Boolean wednesday;
    private final Boolean thursday;
    private final Boolean friday;
}
