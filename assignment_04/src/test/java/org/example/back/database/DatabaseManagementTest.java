package org.example.back.database;

import org.example.back.TestMethod;
import org.example.back.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class DatabaseManagementTest {
    private DatabaseManagement databaseManagement;

    @BeforeEach
    void setUp() {
        this.databaseManagement = new DatabaseManagement();
    }

    @Test
    void 단과대학_테이블_findALL_기능() {
        List<College> result = databaseManagement.findAllCollege();

        TestMethod.printFindAll(result);
    }

    @Test
    public void 단과대학_전화번호_테이블_findAll_기능() throws Exception {
        List<CollegePhone> result = databaseManagement.findAllCollegePhone();

        TestMethod.printFindAll(result);
    }

    @Test
    public void 학과_테이블_findAll_기능() throws Exception {
        List<Department> result = databaseManagement.findALlDepartment();

        TestMethod.printFindAll(result);
    }

    @Test
    public void 교수님_findAll_기능() throws Exception {
        List<Instructor> result = databaseManagement.findAllInstructor();

        TestMethod.printFindAll(result);
    }

    @Test
    public void 교수님_직위_findAll_기능() throws Exception {
        List<InstructorRank> result = databaseManagement.findAllInstructorRank();

        TestMethod.printFindAll(result);
    }

    @Test
    public void 강의_수업_findAll_기능() throws Exception {
        List<Course> result = databaseManagement.findAllCourse();

        TestMethod.printFindAll(result);
    }

    @Test
    public void 분반_findAll_기능() throws Exception {
        List<Section> result = databaseManagement.findAllSection();

        TestMethod.printFindAll(result);
    }

    @Test
    public void 분반_시간_findAll_기능() throws Exception {
        List<SectionTime> result = databaseManagement.findAllSectionTime();

        TestMethod.printFindAll(result);
    }

    @Test
    public void 학생_findAll_기능() throws Exception {
        List<Student> result = databaseManagement.findAllStudent();

        TestMethod.printFindAll(result);
    }
}