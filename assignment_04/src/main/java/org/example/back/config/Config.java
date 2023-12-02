package org.example.back.config;

import org.example.back.entity.College;
import org.example.back.entity.CollegePhone;
import org.example.back.entity.Department;
import org.example.back.entity.Instructor;

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
    public static Instructor getInstructorFromRowArray(List<String> rows) {
        return Instructor.builder()
                .id(rows.get(0))
                .name(rows.get(1))
                .office(rows.get(2))
                .phone(rows.get(3))
                .departmentName(rows.get(4))
                .departmentCode(rows.get(5))
                .collegeName(rows.get(6))
                .chairStartDate(rows.get(7))
                .build();
    }

    //    instructor_rank;

//    course;

//    section;

//    section_time;

//    student;
}
