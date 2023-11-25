package org.example.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Management {
    private final Integer id;
    private final String date;
    private final Integer vacationCount;

    public Management(Integer id, String date, Integer vacationCount) {
        this.id = id;
        this.date = date;
        this.vacationCount = vacationCount;
    }
}
