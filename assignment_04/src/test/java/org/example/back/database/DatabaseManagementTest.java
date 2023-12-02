package org.example.back.database;

import org.example.back.TestMethod;
import org.example.back.entity.College;
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
}