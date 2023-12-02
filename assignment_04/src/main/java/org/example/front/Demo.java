package org.example.front;

import org.example.front.tableView.CollegePhoneTableView;
import org.example.front.tableView.CollegeTableView;
import org.example.front.tableView.InstructorTableView;

import javax.swing.*;
import java.awt.*;

public class Demo extends JFrame {
    private static final Integer MARGIN_WIDTH_VGAP = 10;

    public Demo() {
        setTitle("데이터베이스");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add. main View에 추가
        Container container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.LEFT, MARGIN_WIDTH_VGAP, MARGIN_WIDTH_VGAP));
        container.add(new CollegeTableView());
        container.add(new CollegePhoneTableView());
        container.add(new CollegePhoneTableView());
        container.add(new InstructorTableView());

        setSize(1500, 800);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Demo();
    }
}
