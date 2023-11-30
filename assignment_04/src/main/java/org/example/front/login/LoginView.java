package org.example.front.login;

import org.example.back.controller.LoginController;
import org.example.back.dto.request.LoginRequest;
import org.example.back.dto.response.LoginResponse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class LoginView extends JPanel {
    private LoginResponse loginResponse;

    LoginView() {
        JLabel loginStateLabel = new JLabel("로그인 상태");

        JLabel emailLabel = new JLabel("email");
        JTextField emailTextField = new JTextField(20);

        JLabel passWordLabel = new JLabel("passWord");
        JTextField passWordTextField = new JTextField("1234", 10);

        Button loginButton = new Button("Login");

        loginButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginResponse = new LoginController().login(new LoginRequest(emailTextField.getText(), passWordTextField.getText()));

                if (loginResponse.getIsPass()) {
                    loginStateLabel.setText("로그인 성공");
                } else {
                    loginStateLabel.setText("로그인 실패");
                }
            }
        });

        add(loginStateLabel);
        add(emailLabel);
        add(emailTextField);
        add(passWordLabel);
        add(passWordTextField);
        add(loginButton);
    }

    public Integer getMemberId() {
        return this.loginResponse.getId();
    }

    public Boolean isLoginPass() {
        return this.loginResponse.getIsPass();
    }

}
