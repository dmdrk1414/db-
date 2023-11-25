package org.example.domain;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString

public class Member {
    private final Integer id;
    private final String name;
    private final String email;
    private final String password;
    private final String grade;
    private final String phonNumber;
}
