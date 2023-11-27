package org.example.back.controller;

import org.example.back.dto.request.LoginRequest;
import org.example.back.dto.response.LoginResponse;
import org.example.back.service.LoginService;

public class LoginController {
    private final LoginService loginService;

    public LoginController() {
        this.loginService = new LoginService();
    }

    public LoginResponse login(LoginRequest loginRequest) {
        Boolean isPass = loginService.isMember(loginRequest);
        Integer id = loginService.getId(loginRequest);

        return LoginResponse.builder()
                .isPass(isPass)
                .id(id)
                .build();
    }
}
