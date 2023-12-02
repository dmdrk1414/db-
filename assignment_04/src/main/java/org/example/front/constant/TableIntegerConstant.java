package org.example.front.constant;

import lombok.Getter;

@Getter
public enum TableIntegerConstant {
    // 스크롤 테이블 높이
    JSCROLL_PANE_HIGHT(120),

    // 테이블 높이 크기
    TABLE_ROW_HEIGHT(15),

    // 라벨 글자 크기
    LABEL_FONT_SIZE(20),
    LABEL_MARGIN(10);

    private final int name;

    TableIntegerConstant(Integer value) {
        this.name = value;
    }
}
