package org.example.front.view;

import org.example.back.database.DatabaseManagement;
import org.example.back.entity.CourseTake;
import org.example.front.tableView.CourseTakeTableView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class ApplyView extends JPanel {
    JPanel applyWestPanel1 = new JPanel();
    JPanel applyCenterPanel2 = new JPanel();
    JPanel deleteSouthFrame = new JPanel();
    CourseTakeTableView courseTakeTableView = new CourseTakeTableView();

    public ApplyView() {

        JLabel loginStateLabel = new JLabel("수강 신청");

        setLayout(new BorderLayout());

        add(loginStateLabel, BorderLayout.NORTH);
        add(applyWestPanel1, BorderLayout.WEST);
        add(applyCenterPanel2, BorderLayout.CENTER);
        add(courseTakeTableView, BorderLayout.EAST);
        add(deleteSouthFrame, BorderLayout.SOUTH);

        makeApplyView();
        makeDeleteView();
    }

    private void makeDeleteView() {
        JPanel deleteWest = new JPanel();
        deleteSouthFrame.setLayout(new BorderLayout());

        deleteSouthFrame.add(new JLabel("수강 삭제"), BorderLayout.NORTH);
        deleteSouthFrame.add(deleteWest, BorderLayout.WEST);

        JTextField idTextField = new JTextField("1", 5);
        Button deleteButton = new Button("delete");
        deleteWest.add(new JLabel("course_take id"));
        deleteWest.add(idTextField);
        deleteWest.add(deleteButton);

        deleteButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Boolean isDelete = new DatabaseManagement().deleteCourseTakeById(idTextField.getText());
                if (isDelete) {
                    courseTakeTableView.initTable();

                    List<CourseTake> allCourseTakes = new DatabaseManagement().findAllCourseTake();

                    for (CourseTake courseTake : allCourseTakes) {
                        String[] rowData = {courseTake.getId(), courseTake.getStudentId(), courseTake.getCourseName(), courseTake.getCourseCode(), courseTake.getSectionDevisionNumber()};
                        courseTakeTableView.addDataToTable(rowData);
                    }
                }

                idTextField.setText("");
            }
        });
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
        applyWestPanel1.add(studentIdLabel);
        applyWestPanel1.add(studentIdTextField);

        applyWestPanel1.add(courseNameLabel);
        applyWestPanel1.add(courseNameTextField);

        // 남쪽
        applyCenterPanel2.add(courseCodeLabel);
        applyCenterPanel2.add(courseCodeTextField);

        applyCenterPanel2.add(divisionLabel);
        applyCenterPanel2.add(divisionTextField);

        applyCenterPanel2.add(applyButton);
    }
}
