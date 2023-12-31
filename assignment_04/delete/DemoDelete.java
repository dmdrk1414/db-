package org.example.delete;

import org.example.delete.back.controller.LoginController;
import org.example.delete.back.dto.request.LoginRequest;
import org.example.delete.back.dto.response.LoginResponse;
import org.example.delete.front.view.table.MemberTableView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// TODO: 2023-11-30 로그인을 메인 프레임에 뺀다.
public class DemoDelete extends JFrame {
    private LoginResponse loginResponse;

    public DemoDelete() {
        setTitle("데이터베이스");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel loginFrame = new JPanel();

        Container container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        container.add(new MemberTableView());
        container.add(loginFrame);

        makeLoginView(loginFrame);

        setSize(1500, 800);
        setVisible(true);
    }

    public static void main(String[] args) {
        new DemoDelete();
    }

    private void makeLoginView(JPanel loginFrame) {
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

        loginFrame.add(loginStateLabel);
        loginFrame.add(emailLabel);
        loginFrame.add(emailTextField);
        loginFrame.add(passWordLabel);
        loginFrame.add(passWordTextField);
        loginFrame.add(loginButton);
    }
}