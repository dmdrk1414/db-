package org.example.dto.request;

import lombok.*;
import org.example.domain.Application;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class ApplicationRequest {
    private final String name;
    private final String email;
    private final String password;
    private final String grade;
    private final String phonNumber;
    private final String motivationApplication;
    private final String dream;
    private final String gpa;

    public Application toEntity() {
        return Application.builder()
                .name(name)
                .email(email)
                .password(password)
                .grade(grade)
                .phoneNumber(phonNumber)
                .motivationApplication(motivationApplication)
                .dream(dream)
                .gpa(gpa)
                .build();
    }
}
