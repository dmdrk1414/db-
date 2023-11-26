package org.example.database;

import org.example.domain.Application;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DatabaseTest {
    private Database database;


    @BeforeEach
    void setUp() {
        this.database = new Database();
    }

    @Test
    void saveMemberPortFolio() {
        String name = "신입";
        String email = "new@email.com";
        String password = "1234";
        String grade = "미회원";
        String phonNumber = ("01000000000");
        String motivationApplication = ("테스트 동기 부여");
        String dream = "테스트 꿈";
        String gpa = "4.5";

        Application application = Application.builder()
                .name(name)
                .email(email)
                .password(password)
                .grade(grade)
                .phoneNumber(phonNumber)
                .motivationApplication(motivationApplication)
                .dream(dream)
                .gpa(gpa)
                .build();

        database.saveMemberPortFolio(application);
    }
}