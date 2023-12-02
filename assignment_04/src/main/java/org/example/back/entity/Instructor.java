package org.example.back.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Instructor {
    private final String id;
    private final String name;
    private final String office;
    private final String phone;
    private final String departmentName;
    private final String departmentCode;
    private final String collegeName;
    private final String chairStartDate;
}
