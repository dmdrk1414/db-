package org.example.delete.controller;

import org.example.delete.back.controller.ApplicationController;
import org.example.delete.back.dto.request.ApplicationRequest;
import org.example.delete.back.repository.MemberPortFolioRepository;
import org.example.delete.back.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ApplicationControllerTest {
    private MemberRepository memberRepository;
    private MemberPortFolioRepository memberPortFolioRepository;
    private ApplicationController applicationController;

    @BeforeEach
    void setUp() {
        this.memberRepository = new MemberRepository();
        this.memberPortFolioRepository = new MemberPortFolioRepository();
        this.applicationController = new ApplicationController();
    }

    @Test
    void 신입_지원_테스트() {
        // given
        String name = "신입";
        String email = "new@email.com";
        String password = "1234";
        String grade = "미회원";
        String phonNumber = ("01000000000");
        String motivationApplication = ("테스트 동기 부여");
        String dream = "테스트 꿈";
        String gpa = "4.5";
        ApplicationRequest applicationRequest = ApplicationRequest.builder()
                .name(name)
                .email(email)
                .password(password)
                .grade(grade)
                .phonNumber(phonNumber)
                .motivationApplication(motivationApplication)
                .dream(dream)
                .gpa(gpa)
                .build();

        // when
        String result = applicationController.applyApplication(applicationRequest);
//        Member member = memberRepository.findByEmail(email);
//        MemberPortfolio memberPortfolio = memberPortFolioRepository.findByMemberId(1);
        // than
//        assertThat(result).contains("가입 완료");

//        assertThat(member.getName()).contains(name);
//        assertThat(member.getEmail()).contains(email);
//        assertThat(member.getPassword()).contains(password);
//        assertThat(member.getGrade()).contains(gpa);
//        assertThat(member.getPhonNumber()).contains(phonNumber);

//        assertThat(memberPortfolio.getMotivationApplication()).contains("1번 회원의 동기부여");
//        assertThat(memberPortfolio.getGpa()).contains(gpa);
//        assertThat(memberPortfolio.getDream()).contains(dream);
    }
}