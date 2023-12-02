package org.example.back.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Student {
    private final String id;
    private final String name;
    private final String address;
    private final String phone;
    private final String major;
    private final String departmentName;
    private final String departmentCode;
}
