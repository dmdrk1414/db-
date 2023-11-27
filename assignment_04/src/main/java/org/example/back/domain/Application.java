package org.example.back.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Application {
    private final String name;
    private final String email;
    private final String password;
    private final String grade;
    private final String phoneNumber;
    private final String motivationApplication;
    private final String dream;
    private final String gpa;
}
