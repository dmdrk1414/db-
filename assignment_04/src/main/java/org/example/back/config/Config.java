package org.example.back.config;

import org.example.back.entity.College;
import org.example.back.entity.CollegePhone;
import org.example.back.entity.Department;

import java.util.List;

public class Config {
    public static College getCollegeFromRowArray(List<String> rows) {
        return College.builder()
                .name(rows.get(0))
                .office(rows.get(1))
                .build();
    }

    //    college_phone;
    public static CollegePhone getCollegePhoneFromRowArray(List<String> rows) {
        return CollegePhone.builder()
                .id(rows.get(0))
                .phone(rows.get(1))
                .collegeName(rows.get(2))
                .build();
    }

    //    department;
    public static Department getDepartmentFromRowArray(List<String> rows) {
        return Department.builder()
                .code(rows.get(0))
                .name(rows.get(1))
                .office(rows.get(2))
                .phone(rows.get(3))
                .collegeName(rows.get(4))
                .build();
    }
//    instructor;
//    instructor_rank;
//    course;
//    section;
//    section_time;
//    student;
}
