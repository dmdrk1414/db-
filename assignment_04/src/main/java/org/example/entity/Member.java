package org.example.entity;

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

    public boolean is(String email, String password) {
        return hasMember(email, password);
    }

    private boolean hasMember(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }
}
