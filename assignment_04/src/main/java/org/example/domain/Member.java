package org.example.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Member {
    private final Integer id;
    private final String name;
    private final String email;
    private final String password;
    private final String grade;
    private final String phonNumber;

    public Member(Integer id, String name, String email, String password, String grade, String phonNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.grade = grade;
        this.phonNumber = phonNumber;
    }
}
