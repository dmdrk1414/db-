package org.example.back.database;

import org.example.back.config.Config;
import org.example.back.constant.RowConstant;
import org.example.back.entity.InstructorRank;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBInstructorRank {
    private static final Integer INSTRUCTOR_RANK_COUNT = RowConstant.INSTRUCTOR_RANK.getRowCount();
    private final Statement statement;
    private final Connection connection;

    public DBInstructorRank(Statement dbStatement, Connection connection) {
        this.statement = dbStatement;
        this.connection = connection;
    }

    public List<InstructorRank> findAll() {
        List<InstructorRank> instructorRanks = new ArrayList<>();
        InstructorRank instructorRank = null;

        try {
            String sql = "SELECT * FROM instructor_rank"; // SQL 쿼리
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                List<String> rows = new ArrayList<>();

                for (int i = 1; i <= INSTRUCTOR_RANK_COUNT; i++) {
                    rows.add(resultSet.getString(i));
                }

                instructorRank = Config.getInstructorRankFromRowArray(rows);
                instructorRanks.add(instructorRank);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return instructorRanks;
    }
}
