package org.example.controller;

import org.example.dto.request.LoginRequest;
import org.example.service.LoginService;

public class LoginController {
    private final LoginService loginService;

    public LoginController() {
        this.loginService = new LoginService();
    }

    public Boolean login(LoginRequest loginRequest) {
        return loginService.isMember(loginRequest);
    }
}
