package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Management {
    private final Integer id;
    private final String date;
    private final Integer vacationCount;
}
