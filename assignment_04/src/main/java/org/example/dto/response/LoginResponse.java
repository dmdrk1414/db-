package org.example.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@ToString
public class LoginResponse {
    private final Boolean isPass;
    private final String grade;
}
