package org.example.front;

import javax.swing.*;
import java.awt.*;

public class Demo extends JFrame {
    public Demo() {
        setTitle("데이터베이스");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = getContentPane();

        setSize(1500, 800);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Demo();
    }
}
