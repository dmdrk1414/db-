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
    public static Section getSectionFromRowArray(List<String> rows) {
        return Section.builder()
                .id(rows.get(0))
                .devisionNumber(rows.get(1))
                .month(rows.get(2))
                .year(rows.get(3))
                .day(rows.get(4))
                .instructorId(rows.get(5))
                .courseCode(rows.get(6))
                .courseName(rows.get(7))
                .roomNumber(rows.get(8))
                .building(rows.get(9))
                .build();
    }

    //    section_time;
    public static SectionTime getSectionTimeFromRowArray(List<String> rows) {
        return SectionTime.builder()
                .id(rows.get(0))
                .time(rows.get(1))
                .sectionId(rows.get(2))
                .build();
    }

    //    student;
    public static Student getStudentFromRowArray(List<String> rows) {
        return Student.builder()
                .id(rows.get(0))
                .name(rows.get(1))
                .address(rows.get(2))
                .phone(rows.get(3))
                .major(rows.get(4))
                .departmentName(rows.get(5))
                .departmentCode(rows.get(6))
                .build();
    }

    public static CourseTake getCourceTakeFromRowArray(List<String> rows) {
        return CourseTake.builder()
                .id(rows.get(0))
                .studentId(rows.get(1))
                .courseName(rows.get(2))
                .courseCode(rows.get(3))
                .sectionDevisionNumber(rows.get(4))
                .build();
    }
}
