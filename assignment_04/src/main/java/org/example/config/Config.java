package org.example.config;

import org.example.domain.*;

import java.util.List;

public class Config {
    public static AttendanceStatus getAttendanceStatusFromRowArray(List<String> rows) {
        return AttendanceStatus.builder()
                .id(Integer.valueOf(rows.get(0)))
                .status(rows.get(1))
                .attendanceTime(rows.get(2))
                .attendanceDate(rows.get(3))
                .memberId(Integer.valueOf(rows.get(4)))
                .build();
    }

    public static Management getManagementFromRowArray(List<String> rows) {
        return Management.builder()
                .id(Integer.valueOf(rows.get(0)))
                .date(rows.get(1))
                .vacationCount(Integer.valueOf(rows.get(2)))
                .memberId(Integer.valueOf(rows.get(3)))
                .build();
    }

    public static Member getMemberFromRowArray(List<String> rows) {
        return Member.builder()
                .id(Integer.valueOf(rows.get(0)))
                .name(rows.get(1))
                .email(rows.get(2))
                .password(rows.get(3))
                .grade(rows.get(4))
                .phonNumber(rows.get(5))
                .build();
    }

    public static MemberPortfolio getMemberPortfolioFromRowArray(List<String> rows) {
        return MemberPortfolio.builder()
                .id(Integer.valueOf(rows.get(0)))
                .motivationApplication(rows.get(1))
                .gpa(rows.get(2))
                .dream(rows.get(3))
                .memberId(Integer.valueOf(rows.get(4)))
                .build();
    }

    public static Post getPostFromRowArray(List<String> rows) {
        return Post.builder()
                .id(Integer.valueOf(rows.get(0)))
                .title(rows.get(1))
                .content(rows.get(2))
                .postDate(rows.get(3))
                .memberId(Integer.valueOf(rows.get(4)))
                .build();
    }

    public static TimeTable getTimeTableFromRowArray(List<String> rows) {
        return TimeTable.builder()
                .id(Integer.valueOf(rows.get(0)))
                .image(rows.get(1))
                .applyDate(rows.get(2))
                .memberId(Integer.valueOf(rows.get(3)))
                .build();
    }
}
