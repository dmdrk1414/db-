package org.example.delete.back.constant;

import lombok.Getter;

@Getter
public enum RowCount {
    ATTENDANCE_STATUS(5),
    MANAGEMENT(4),
    MEMBER(6),
    MEMBER_PORTFOLIO(5),
    POST(5),
    TIME_TABLE(4),
    WEEK_DATA(7);

    private final Integer rowCount;

    RowCount(Integer rowCount) {
        this.rowCount = rowCount;
    }
}
