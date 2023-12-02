package org.example.front.tableView;

import org.example.back.database.DatabaseManagement;
import org.example.back.entity.CourseTake;
import org.example.front.constant.DBTable;
import org.example.front.constant.TableIntegerConstant;
import org.example.front.constant.TableStringConstant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CourseTakeTableView extends JPanel {

    private static final String TABLE_NAME = TableStringConstant.TABLE_NAME_COURSE_TAKE.getName(); // add 1. 원하는 테이블 선택
    private static final Integer JSCROLL_PANE_HIGHT = TableIntegerConstant.JSCROLL_PANE_HIGHT.getName();
    private static final Integer JSCROLL_PANE_WIDTH = TableIntegerConstant.JSCROLL_PANE_WIDTH.getName();
    private final String[] tableColumnNames;
    private final DefaultTableModel mainTable;
    private final JTable table;

    public CourseTakeTableView() {
        tableColumnNames = new DBTable().get(TABLE_NAME);
        mainTable = new DefaultTableModel(tableColumnNames, 0);
        table = new JTable(mainTable);
        JLabel jLabel = new JLabel(TABLE_NAME + "  테이블");
        JScrollPane jScrollPane = new JScrollPane(table);

        setLayout(new BorderLayout());
        add(jLabel, BorderLayout.CENTER);
        add(jScrollPane, BorderLayout.SOUTH);

        // 테이블 크기
        table.setRowHeight(TableIntegerConstant.TABLE_ROW_HEIGHT.getName());

        // 라벨 글자 크기
        int fontSize = TableIntegerConstant.LABEL_FONT_SIZE.getName();
        Font font = new Font(jLabel.getFont().getName(), Font.PLAIN, fontSize);
        jLabel.setFont(font);

        int margin = TableIntegerConstant.LABEL_MARGIN.getName();
        jLabel.setBorder(new EmptyBorder(margin, margin, margin, margin));

        // 스크롤
        // JScrollPane의 높이를 수정
        jScrollPane.setPreferredSize(new Dimension(jScrollPane.getPreferredSize().width, JSCROLL_PANE_HIGHT));

        // JScrollPane의 넓이 수정
        jScrollPane.setPreferredSize(new Dimension(JSCROLL_PANE_WIDTH, jScrollPane.getPreferredSize().height));

        creatTable();
    }

    public void initTable() {
        mainTable.setRowCount(0); // 기존 데이터 삭제
    }

    public void creatTable() {

        String[] columRow;
        List<CourseTake> list = new DatabaseManagement().findAllCourseTake(); // add 4. 원하는 객체 선택

        for (CourseTake courseTake : list) { // add 5. 원하는 객체 선택
            columRow = courseTake.ofArray();
            mainTable.addRow(columRow);
        }
    }

    public void addDataToTable(String[] rowData) {
        mainTable.addRow(rowData);
    }
}