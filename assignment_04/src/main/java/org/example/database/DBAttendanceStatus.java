package org.example.database;

import org.example.config.Config;
import org.example.constant.RowCount;
import org.example.domain.AttendanceStatus;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBAttendanceStatus {
    private static final Integer ATTENDANCE_STATUS_ROW_COUNT = RowCount.ATTENDANCE_STATUS.getRowCount();
    private final Statement statement;

    public DBAttendanceStatus(Statement dbStatement) {
        this.statement = dbStatement;
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

                attendanceStatus = Config.getAttendanceStatus(rows);
                attendanceStatuses.add(attendanceStatus);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return attendanceStatuses;
    }


}
