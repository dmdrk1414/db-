package org.example.back.controller;

import org.example.back.domain.Application;
import org.example.back.dto.request.ApplicationRequest;
import org.example.back.dto.response.BaseResponse;
import org.example.back.service.*;

public class ApplicationController {
    private final MemberService memberService;
    private final MemberPortFolioService memberPortFolioService;
    private final AttendanceStatusService attendanceStatusService;
    private final WeekDataService weekDataService;
    private final ManagementService managementService;

    public ApplicationController() {
        this.memberService = new MemberService();
        this.memberPortFolioService = new MemberPortFolioService();
        this.attendanceStatusService = new AttendanceStatusService();
        this.weekDataService = new WeekDataService();
        this.managementService = new ManagementService();
    }

    public String applyApplication(ApplicationRequest applicationRequest) {
        Application application = applicationRequest.toEntity();

        if (isApply(application)) {
            return new BaseResponse().applyOk();
        }
        return new BaseResponse().applyNo();

    }

    // TODO: 2023-11-27 management Table 생성을 해야한다.
    private boolean isApply(Application application) {
        return memberService.save(application)
                && memberPortFolioService.save(application)
                && attendanceStatusService.save(application)
                && managementService.save(application)
                && weekDataService.save(application);
    }
}
