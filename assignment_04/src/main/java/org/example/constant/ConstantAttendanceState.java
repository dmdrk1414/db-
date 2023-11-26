package org.example.constant;

import lombok.Getter;

@Getter
public enum ConstantAttendanceState {
    dN_DECIDED("미정"),
    VACATION("휴가"),
    ABSENCE("결석"),
    ATTENDANCE("출석");

    private final String state;

    ConstantAttendanceState(String state) {
        this.state = state;
    }
}
