package org.example.back.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Instructor {
    private final Integer id;
    private final Integer name;
    private final Integer office;
    private final Integer phone;
    private final Integer departmentName;
    private final Integer departmentCode;
    private final Integer collegeName;
    private final Integer chairStartDate;
}
