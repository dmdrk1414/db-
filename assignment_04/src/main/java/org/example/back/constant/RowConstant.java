package org.example.back.constant;

import lombok.Getter;

@Getter
public enum RowConstant {
    COLLEGE(2),
    COLLEGE_PHONE(3),
    DEPARTMENT(5),
    INSTRUCTOR(8),
    INSTRUCTOR_RANK(2),
    COURSE(7),
    SECTION(10),
    SECTION_TIME(3),
    STUDENT(7),
    COURSE_TAKE(5);

    private final Integer rowCount;

    RowConstant(Integer rowCount) {
        this.rowCount = rowCount;
    }
}
