package org.example.back.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Course {
    private final String code;
    private final String name;
    private final String credits;
    private final String courseLevel;
    private final String description;
    private final String departmentName;
    private final String departmentCode;
}
