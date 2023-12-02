package org.example.back.config;

import org.example.back.entity.*;

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
    public static InstructorRank getInstructorRankFromRowArray(List<String> rows) {
        return InstructorRank.builder()
                .instructorId(rows.get(0))
                .rank(rows.get(1))
                .build();
    }

    //    course;
    public static Course getCourceFromRowArray(List<String> rows) {
        return Course.builder()
                .code(rows.get(0))
                .name(rows.get(1))
                .credits(rows.get(2))
                .courseLevel(rows.get(3))
                .description(rows.get(4))
                .departmentName(rows.get(5))
                .departmentCode(rows.get(6))
                .build();
    }
//    section;

//    section_time;

//    student;
}
