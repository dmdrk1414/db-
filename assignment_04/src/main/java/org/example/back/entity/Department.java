package org.example.back.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Department {
    private final String code;
    private final String name;
    private final String office;
    private final String phone;
    private final String collegeName;
}
