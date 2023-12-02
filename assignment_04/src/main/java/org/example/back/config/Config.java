package org.example.back.config;

import org.example.back.entity.College;

import java.util.List;

public class Config {
    public static College getCollegeFromRowArray(List<String> rows) {
        return College.builder()
                .name(rows.get(0))
                .office(rows.get(1))
                .build();
    }
}
