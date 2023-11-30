package org.example;

import org.example.back.controller.LoginController;
import org.example.back.dto.request.LoginRequest;
import org.example.back.dto.response.LoginResponse;
import org.example.front.login.ApplicationFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// TODO: 2023-11-30 로그인을 메인 프레임에 뺀다.
public class Demo extends JFrame {
    private LoginResponse loginResponse;

    public Demo() {
        setTitle("데이터베이스");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel loginPanel = new JPanel();

        Container container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 10));
        container.add(new ApplicationFrame());
        container.add(loginPanel);

        makeLoginView(loginPanel);

        setSize(1500, 800);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Demo();
    }

    private void makeLoginView(JPanel testView) {
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

        testView.add(loginStateLabel);
        testView.add(emailLabel);
        testView.add(emailTextField);
        testView.add(passWordLabel);
        testView.add(passWordTextField);
        testView.add(loginButton);
    }
}