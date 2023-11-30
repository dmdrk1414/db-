package org.example.back.entity;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@ToString

public class Member {
    private static final Integer SIZE_COUNT = 6;
    private final Integer id;
    private final String name;
    private final String email;
    private final String password;
    private final String grade;
    private final String phoneNumber;

    public boolean is(String email, String password) {
        return hasMember(email, password);
    }

    public String[] ofArray() {

        String[] array = new String[SIZE_COUNT];
        array[0] = String.valueOf(this.id);
        array[1] = this.name;
        array[2] = this.email;
        array[3] = this.password;
        array[4] = this.grade;
        array[5] = this.phoneNumber;

        return array;
    }

    private boolean hasMember(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }
}
