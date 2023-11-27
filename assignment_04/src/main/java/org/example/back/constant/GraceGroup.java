package org.example.back.constant;

import java.util.List;

public enum GraceGroup {
    GRADE("등급", List.of(Grade.KING, Grade.GENERAL_AFFAIRS, Grade.REGULAR_MEMBER, Grade.NON_MEMBER));

    private final String name;
    private final List<Grade> grades;

    GraceGroup(String name, List<Grade> grades) {
        this.name = name;
        this.grades = grades;
    }
}
