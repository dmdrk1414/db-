package org.example.front.login;

import org.example.back.controller.DataBaseController;
import org.example.back.entity.Member;
import org.example.front.constant.DBTable;
import org.example.front.inter.ViewBasic;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ApplicationFrame extends JPanel implements ViewBasic {

    private final String[] dbColumnNames;
    private final DefaultTableModel mainTable;
    private final JTable mamberTable;

    public ApplicationFrame() {
        dbColumnNames = new DBTable().get("member");
        mainTable = new DefaultTableModel(dbColumnNames, 0);
        mamberTable = new JTable(mainTable);

        setLayout(new BorderLayout());
        add(mamberTable, BorderLayout.NORTH);

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
