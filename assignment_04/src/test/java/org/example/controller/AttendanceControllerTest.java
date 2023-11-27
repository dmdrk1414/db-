package org.example.controller;

import org.example.back.controller.AttendanceController;
import org.example.back.dto.request.AttendanceRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class AttendanceControllerTest {
    private AttendanceController attendanceController;

    @BeforeEach
    void setUp() {
        this.attendanceController = new AttendanceController();
    }

    @Test
    void passAttendance() {
        AttendanceRequest attendanceRequest = new AttendanceRequest("1234", 9);

        Boolean result = attendanceController.passAttendance(attendanceRequest);

        assertThat(result).isTrue();

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 7})
    void 출석번호입력후_출석확인(Integer memberId) {
        AttendanceRequest attendanceRequest = new AttendanceRequest("1234", memberId);

        Boolean result = attendanceController.passAttendance(attendanceRequest);

        assertThat(result).isFalse();
    }
}