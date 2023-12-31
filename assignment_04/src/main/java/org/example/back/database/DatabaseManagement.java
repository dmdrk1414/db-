package org.example.back.database;

import lombok.Getter;
import org.example.back.entity.*;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

@Getter
public class DatabaseManagement {
    private final Statement dbStatement;
    private final Connection connection;

    public DatabaseManagement() {
        DBConnection dbConnection = new DBConnection();
        this.dbStatement = dbConnection.getStatement();
        this.connection = dbConnection.getConnection();
    }

    public List<College> findAllCollege() {
        return new DBCollege(dbStatement, connection).findAll();
    }

    public List<CollegePhone> findAllCollegePhone() {
        return new DBCollegePhone(dbStatement, connection).findAll();
    }

    public List<Department> findALlDepartment() {
        return new DBDepartment(dbStatement, connection).findAll();
    }

    public List<Instructor> findAllInstructor() {
        return new DBInstructor(dbStatement, connection).findAll();
    }

    public List<InstructorRank> findAllInstructorRank() {
        return new DBInstructorRank(dbStatement, connection).findAll();
    }

    public List<Course> findAllCourse() {
        return new DBCourse(dbStatement, connection).findAll();
    }

    public List<Section> findAllSection() {
        return new DBSection(dbStatement, connection).findAll();
    }

    public List<SectionTime> findAllSectionTime() {
        return new DBSectionTime(dbStatement, connection).findAll();
    }

    public List<Student> findAllStudent() {
        return new DBStudent(dbStatement, connection).findAll();
    }

    public List<CourseTake> findAllCourseTake() {
        return new DBCourseTake(dbStatement, connection).findAll();
    }

    public Boolean applyCourseTake(String studentId, String courseName, String courseCode, String sectionDevisionNumber) {
        return new DBCourseTake(dbStatement, connection).save(studentId, courseName, courseCode, sectionDevisionNumber);
    }

    public CourseTake findCourseTakeByStudentId(String studentId) {
        return new DBCourseTake(dbStatement, connection).findByStudentId(studentId);
    }

    public Boolean deleteCourseTakeById(String id) {
        return new DBCourseTake(dbStatement, connection).deleteById(id);
    }
}