package org.example.front.tableView;

import org.example.back.database.DatabaseManagement;
import org.example.back.entity.Instructor;
import org.example.front.constant.DBTable;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class InstructorTableView extends JPanel {

    private static final String TABLE_NAME = "instructor"; // add 1. 원하는 테이블 선택
    private static final Integer JSCROLL_PANE_HIGHT = 120;
    private final String[] tableColumnNames;
    private final DefaultTableModel mainTable;
    private final JTable table;

    public InstructorTableView() {
        tableColumnNames = new DBTable().get(TABLE_NAME);
        mainTable = new DefaultTableModel(tableColumnNames, 0);
        table = new JTable(mainTable);
        JLabel jLabel = new JLabel(TABLE_NAME + "  테이블");
        JScrollPane jScrollPane = new JScrollPane(table);

        setLayout(new BorderLayout());
        add(jLabel, BorderLayout.CENTER);
        add(jScrollPane, BorderLayout.SOUTH);

        // 테이블 크기
        table.setRowHeight(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(220); // add 3. 원하는 컬럼의 넓이

        // 라벨 글자 크기
        int fontSize = 20;
        Font font = new Font(jLabel.getFont().getName(), Font.PLAIN, fontSize);
        jLabel.setFont(font);

        int margin = 10;
        jLabel.setBorder(new EmptyBorder(margin, margin, margin, margin));

        // 스크롤
        // JScrollPane의 높이를 수정
        jScrollPane.setPreferredSize(new Dimension(jScrollPane.getPreferredSize().width, JSCROLL_PANE_HIGHT));

        creatTable();
    }

    public void creatTable() {
        String[] columRow;
        List<Instructor> list = new DatabaseManagement().findAllInstructor(); // add 4. 원하는 객체 선택

        for (Instructor instructor : list) { // add 5. 원하는 객체 선택
            columRow = instructor.ofArray();
            mainTable.addRow(columRow);
        }
    }
}
