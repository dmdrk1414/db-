package org.example.delete.front.view.table;

import org.example.delete.back.controller.DataBaseController;
import org.example.delete.back.entity.Member;
import org.example.delete.front.constant.DBTable;
import org.example.delete.front.inter.TableViewBasic;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class AttendanceStatus extends JPanel implements TableViewBasic {

    private static final String MEMBER_TABLE = "member";
    private final String[] memberTableColumnNames;
    private final DefaultTableModel mainTable;
    private final JTable mamberTable;

    public AttendanceStatus() {
        memberTableColumnNames = new DBTable().get(MEMBER_TABLE);
        mainTable = new DefaultTableModel(memberTableColumnNames, 0);
        mamberTable = new JTable(mainTable);

        setLayout(new BorderLayout());
        add(new JLabel(MEMBER_TABLE + " 회원 관리 테이블"), BorderLayout.NORTH);
        add(mamberTable, BorderLayout.CENTER);

        creatTable();
    }

    @Override
    public void creatTable() {
        String[] columRow;
        List<Member> members = new DataBaseController().findAllMember();

        for (Member member : members) {
            columRow = member.ofArray();
            mainTable.addRow(columRow);
        }
    }
}
