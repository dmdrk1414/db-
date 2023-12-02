package org.example.back.database;

import org.example.back.TestMethod;
import org.example.back.entity.College;
import org.example.back.entity.CollegePhone;
import org.example.back.entity.Department;
import org.example.back.entity.Instructor;
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
}