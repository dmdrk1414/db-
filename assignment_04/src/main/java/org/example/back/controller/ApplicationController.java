package org.example.back.controller;

import org.example.back.domain.Application;
import org.example.back.dto.request.ApplicationRequest;
import org.example.back.dto.response.BaseResponse;
import org.example.back.service.AttendanceStatusService;
import org.example.back.service.MemberPortFolioService;
import org.example.back.service.MemberService;

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
