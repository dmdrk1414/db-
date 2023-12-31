package org.example.delete.back.dto.request;

import lombok.*;
import org.example.delete.back.domain.Login;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class LoginRequest {
    private final String email;
    private final String password;

    public Login toEntity() {
        return Login.builder()
                .email(email)
                .password(password)
                .build();
    }
}
