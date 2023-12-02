package org.example.front.view;

import org.example.back.database.DatabaseManagement;
import org.example.back.entity.CourseTake;
import org.example.front.tableView.CourseTakeTableView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ApplyView extends JPanel {
    JPanel applyCenterPanel1 = new JPanel();
    JPanel applySouthPanel2 = new JPanel();
    CourseTakeTableView courseTakeTableView = new CourseTakeTableView();

    public ApplyView() {

        JLabel loginStateLabel = new JLabel("수강 신청");

        setLayout(new BorderLayout());

        add(loginStateLabel, BorderLayout.NORTH);
        add(applyCenterPanel1, BorderLayout.WEST);
        add(applySouthPanel2, BorderLayout.CENTER);
        add(courseTakeTableView, BorderLayout.EAST);

        makeApplyView();
    }

    private void makeApplyView() {
        JLabel studentIdLabel = new JLabel("학생 id");
        JTextField studentIdTextField = new JTextField("1", 5);

        JLabel courseNameLabel = new JLabel("수강 과목");
        JTextField courseNameTextField = new JTextField("인공지능", 10);

        JLabel courseCodeLabel = new JLabel("수강 코드");
        JTextField courseCodeTextField = new JTextField("it01", 10);

        JLabel divisionLabel = new JLabel("수강 분반");
        JTextField divisionTextField = new JTextField("1", 5);


        Button applyButton = new Button("apply");

        applyButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean isApply = new DatabaseManagement().applyCourseTake(studentIdTextField.getText(), courseNameTextField.getText(), courseCodeTextField.getText(), studentIdTextField.getText());
                if (isApply) {
                    CourseTake courseTake = new DatabaseManagement().findCourseTakeByStudentId(studentIdTextField.getText());
                    String[] rowData = {courseTake.getId(), courseTake.getStudentId(), courseTake.getCourseName(), courseTake.getCourseCode(), courseTake.getSectionDevisionNumber()};
                    courseTakeTableView.addDataToTable(rowData);
                }

                studentIdTextField.setText("");
                courseNameTextField.setText("");
                courseCodeTextField.setText("");
                divisionTextField.setText("");

            }
        });

        // 센터
        applyCenterPanel1.add(studentIdLabel);
        applyCenterPanel1.add(studentIdTextField);

        applyCenterPanel1.add(courseNameLabel);
        applyCenterPanel1.add(courseNameTextField);

        // 남쪽
        applySouthPanel2.add(courseCodeLabel);
        applySouthPanel2.add(courseCodeTextField);

        applySouthPanel2.add(divisionLabel);
        applySouthPanel2.add(divisionTextField);

        applySouthPanel2.add(applyButton);
    }
}
