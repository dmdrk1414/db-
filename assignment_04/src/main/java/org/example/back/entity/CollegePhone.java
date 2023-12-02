package org.example.back.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class CollegePhone {
    private final Integer id;
    private final String phone;
    private final String college_name;
}
