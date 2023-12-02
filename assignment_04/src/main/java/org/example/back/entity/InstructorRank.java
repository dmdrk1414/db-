package org.example.back.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class InstructorRank {
    private final Integer instructorId;
    private final String rank;
}
