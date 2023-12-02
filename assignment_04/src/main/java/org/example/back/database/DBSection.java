package org.example.back.database;

import org.example.back.config.Config;
import org.example.back.constant.RowConstant;
import org.example.back.entity.Section;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBSection {
    private static final Integer SECTION_ROW_COUNT = RowConstant.SECTION.getRowCount();
    private final Statement statement;
    private final Connection connection;

    public DBSection(Statement dbStatement, Connection connection) {
        this.statement = dbStatement;
        this.connection = connection;
    }

    public List<Section> findAll() {
        List<Section> sections = new ArrayList<>();
        Section section = null;

        try {
            String sql = "SELECT * FROM section"; // SQL 쿼리
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                List<String> rows = new ArrayList<>();

                for (int i = 1; i <= SECTION_ROW_COUNT; i++) {
                    rows.add(resultSet.getString(i));
                }

                section = Config.getSectionFromRowArray(rows);
                sections.add(section);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return sections;
    }
}
