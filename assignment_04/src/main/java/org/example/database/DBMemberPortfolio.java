package org.example.database;

import org.example.config.Config;
import org.example.constant.RowCount;
import org.example.entity.MemberPortfolio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBMemberPortfolio {
    private static final Integer MEMBER_PORTFOLIO_ROW_COUNT = RowCount.MEMBER_PORTFOLIO.getRowCount();
    private final Statement statement;

    public DBMemberPortfolio(Statement dbStatement) {
        this.statement = dbStatement;
    }

    public List<MemberPortfolio> findAll() {
        // 수정
        List<MemberPortfolio> memberPortfolios = new ArrayList<>();
        MemberPortfolio memberPortfolio = null;

        try {
            // 수정
            String sql = "SELECT * FROM member_portfolio"; // SQL 쿼리
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                List<String> rows = new ArrayList<>();

                for (int i = 1; i <= MEMBER_PORTFOLIO_ROW_COUNT; i++) {
                    rows.add(resultSet.getString(i));
                }

                memberPortfolio = Config.getMemberPortfolioFromRowArray(rows);
                memberPortfolios.add(memberPortfolio);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return memberPortfolios;
    }
}
