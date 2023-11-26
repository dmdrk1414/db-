package org.example.controller;

import org.example.domain.Application;
import org.example.dto.request.ApplicationRequest;
import org.example.dto.response.BaseResponse;
import org.example.entity.AttendanceStatus;
import org.example.entity.Member;
import org.example.entity.MemberPortfolio;
import org.example.service.AttendanceStatusService;
import org.example.service.MemberPortFolioService;
import org.example.service.MemberService;

public class ApplicationController {
    private final MemberService memberService;
    private final MemberPortFolioService memberPortFolioService;
    private final AttendanceStatusService attendanceStatusService;

    public ApplicationController() {
        this.memberService = new MemberService();
        this.memberPortFolioService = new MemberPortFolioService();
        this.attendanceStatusService = new AttendanceStatusService();
    }

    public String applyApplication(ApplicationRequest applicationRequest) {
        Application application = applicationRequest.toEntity();

        if (isApply(application)) {
            return new BaseResponse().applyOk();
        }
        return new BaseResponse().applyNo();

    }

    private boolean isApply(Application application) {
        return memberService.save(application)
                && memberPortFolioService.save(application)
                && attendanceStatusService.save(application);
    }
}
