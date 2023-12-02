package org.example.delete.back.database;

import org.example.delete.back.config.Config;
import org.example.delete.back.constant.RowCount;
import org.example.delete.back.entity.AttendanceStatus;
import org.example.delete.back.constant.ConstantAttendanceState;
import org.example.delete.back.domain.Application;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBAttendanceStatus {
    private static final Integer ATTENDANCE_STATUS_ROW_COUNT = RowCount.ATTENDANCE_STATUS.getRowCount();
    private final Statement statement;
    private final Connection connection;

    public DBAttendanceStatus(Statement dbStatement, Connection connection) {
        this.statement = dbStatement;
        this.connection = connection;
    }

    public List<AttendanceStatus> findAll() {
        List<AttendanceStatus> attendanceStatuses = new ArrayList<>();
        AttendanceStatus attendanceStatus = null;

        try {
            String sql = "SELECT * FROM attendance_status"; // SQL 쿼리
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                List<String> rows = new ArrayList<>();

                for (int i = 1; i <= ATTENDANCE_STATUS_ROW_COUNT; i++) {
                    rows.add(resultSet.getString(i));
                }

                attendanceStatus = Config.getAttendanceStatusFromRowArray(rows);
                attendanceStatuses.add(attendanceStatus);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return attendanceStatuses;
    }

    public boolean save(Application application) {
        String sql = "INSERT INTO attendance_status (status, attendance_time, attendance_date, member_id)" +
                " VALUES (?, ?, SYSDATE, ? )";
        String memberId = findMemberId(application.getEmail());

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, ConstantAttendanceState.dN_DECIDED.getState());
            preparedStatement.setString(2, "09");
//            preparedStatement.setString(3, "SYSDATE");
            preparedStatement.setString(3, memberId);

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

    public Boolean updateAttendanceStatus(Integer memberId) {
        String sql = "UPDATE attendance_status SET status = ? WHERE member_id = " + memberId;

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            if (isAllReadAttendance(memberId)) {
                return false;
            }

            preparedStatement.setString(1, ConstantAttendanceState.ATTENDANCE.getState());
            preparedStatement.executeUpdate();

            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve member by email", e);
        }
    }

    private AttendanceStatus findByMemberId(Integer memberId) {
        AttendanceStatus attendanceStatus = null;
        String sql = "SELECT * FROM attendance_status WHERE id = ?";

        try (
                PreparedStatement preparedStatement = connection.prepareStatement(sql)
        ) {
            preparedStatement.setString(1, String.valueOf(memberId));

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    // ResultSet에서 데이터를 읽어와 Member 객체를 생성하거나 반환 로직 추가
                    attendanceStatus = AttendanceStatus.builder()
                            .id(resultSet.getInt("id"))
                            .status(resultSet.getString("status"))
                            .attendanceTime(resultSet.getString("attendance_time"))
                            .attendanceDate(resultSet.getString("attendance_date"))
                            .memberId(resultSet.getInt("member_id"))
                            .build();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to retrieve member by email", e);
        }

        return attendanceStatus;
    }

    private boolean isAllReadAttendance(Integer id) {
        AttendanceStatus attendanceStatus = findByMemberId(id);
        String status = attendanceStatus.getStatus();

        return status.equals(ConstantAttendanceState.ATTENDANCE.getState()) ||
                status.equals(ConstantAttendanceState.ABSENCE.getState()) ||
                status.equals(ConstantAttendanceState.VACATION.getState());
    }
}
