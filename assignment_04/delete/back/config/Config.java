package org.example.delete.back.config;

import org.example.delete.back.entity.*;

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
                .phoneNumber(rows.get(5))
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

    public static WeekData getWeekDataFromRowArray(List<String> rows) {
        return WeekData.builder()
                .monday(isTrue(rows.get(0)))
                .tuesday(isTrue(rows.get(1)))
                .wednesday(isTrue(rows.get(2)))
                .thursday(isTrue(rows.get(3)))
                .friday(isTrue(rows.get(4)))
                .managementId(Integer.valueOf(rows.get(5)))
                .memberId(Integer.valueOf(rows.get(6)))
                .build();
    }

    private static Boolean isTrue(String numStr) {
        Integer num = Integer.valueOf(numStr);
        if (num == 1) {
            return true;
        }
        return false;
    }
}
