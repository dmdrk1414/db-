package org.example.back.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class Login {
    private final String email;
    private final String password;
}
