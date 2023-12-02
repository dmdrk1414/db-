package org.example.front;

import org.example.front.tableView.*;
import org.example.front.view.ApplyView;

import javax.swing.*;
import java.awt.*;

public class Demo extends JFrame {
    private static final Integer MARGIN_WIDTH_VGAP = 10;
    ImageIcon imageIcon = new ImageIcon(getClass().getResource("/seungchan20161822.png"));
    JLabel label = new JLabel(imageIcon);

    public Demo() {
        setTitle("데이터베이스");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add. main View에 추가
        Container container = getContentPane();
        container.setLayout(new FlowLayout(FlowLayout.LEFT, MARGIN_WIDTH_VGAP, MARGIN_WIDTH_VGAP));
        container.add(new CollegeTableView());
        container.add(new CollegePhoneTableView());
        container.add(new DepartmentTableView());
        container.add(new InstructRankTableView());
        container.add(new InstructorTableView());
        container.add(new SectionTableView());
        container.add(new SectionTimeTableView());
        container.add(new CourseTableView());
        container.add(new StudentTableView());
        container.add(label);
        container.add(new ApplyView());

        setSize(1500, 1000);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Demo();
    }


}
