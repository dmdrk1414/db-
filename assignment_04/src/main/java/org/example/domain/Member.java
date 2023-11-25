package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class Member {
    private final Integer id;
    private final String name;
    private final String email;
    private final String password;
    private final String grade;
    private final String phonNumber;
}
