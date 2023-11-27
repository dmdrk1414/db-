package org.example.back.database;

import org.example.back.config.Config;
import org.example.back.constant.RowCount;
import org.example.back.domain.Application;
import org.example.back.entity.MemberPortfolio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBMemberPortfolio {
    private static final Integer MEMBER_PORTFOLIO_ROW_COUNT = RowCount.MEMBER_PORTFOLIO.getRowCount();
    private final Statement statement;
    private final Connection connection;

    public DBMemberPortfolio(Statement dbStatement, Connection connection) {
        this.statement = dbStatement;
        this.connection = connection;
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

    public Boolean save(Application application) {
        String sql = "INSERT INTO member_portfolio (motivation_application, gpa, dream, member_id)" +
                " VALUES (?, ?, ?, ? )";
        String memberId = findMemberId(application.getEmail());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, application.getMotivationApplication());
            preparedStatement.setString(2, application.getGpa());
            preparedStatement.setString(3, application.getDream());
            preparedStatement.setString(4, memberId);

            int affectedRows = preparedStatement.executeUpdate();
            if (affectedRows > 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return false;
    }

    private String findMemberId(String email) {
        String sql = "SELECT * FROM member WHERE email = ?";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, String.valueOf(email));

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // ResultSet에서 데이터를 읽어와 Member 객체를 생성하거나 반환 로직 추가
                    return resultSet.getString("id");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve member by email", e);
        }

        return null;
    }
}
