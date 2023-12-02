package org.example.front.constant;

import lombok.Getter;

@Getter
public enum TableStringConstant {
    // 테이블 선택
    TABLE_NAME_COLLEGE("college"),
    TABLE_NAME_COLLEGE_PHONE("college_phone"),
    TABLE_NAME_INSTRUCTOR("instructor"),
    TABLE_NAME_INSTRUCTOR_RANK("instructor_rank"),
    TABLE_NAME_DEPARTMENT("department"),
    TABLE_NAME_COURSE("course"),
    TABLE_NAME_SECTION("section"),
    TABLE_NAME_SECTION_TIME("section_time"),
    TABLE_NAME_STUDENT("student"),
    TABLE_NAME_COURSE_TAKE("course_take");

    private final String name;

    TableStringConstant(String name) {
        this.name = name;
    }
}
