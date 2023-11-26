package org.example.controller;

import org.example.dto.request.LoginRequest;
import org.example.dto.response.LoginResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LoginControllerTest {
    private LoginController loginController;

    @BeforeEach
    void setUp() {
        this.loginController = new LoginController();
    }

    @Test
    void 로그인_기능_추가() {
        // given
        LoginRequest loginRequest = LoginRequest.builder()
                .email("test_1@gmail.com")
                .password("1234")
                .build();

        // when
        LoginResponse result = loginController.login(loginRequest);

        // than
        assertThat(result.getIsPass()).isTrue();
        assertThat(result.getId()).isEqualTo(1);
    }
}