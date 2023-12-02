package org.example.back.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class CollegePhone {
    private final String id;
    private final String phone;
    private final String collegeName;
}
