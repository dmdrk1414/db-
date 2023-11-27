package org.example.back.constant;

public enum Grade {
    KING("실장"),
    GENERAL_AFFAIRS("총무"),
    REGULAR_MEMBER("정회원"),
    NON_MEMBER("미회원");

    private final String grade;

    Grade(String grade) {
        this.grade = grade;
    }
}
