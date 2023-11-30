package org.example.back.controller;

import org.example.back.entity.*;
import org.example.back.service.*;

import java.util.List;

public class DataBaseController {
    private final MemberService memberService;
    private final AttendanceStatusService attendanceStatusService;
    private final ManagementService managementService;
    private final MemberPortFolioService memberPortFolioService;
    private final PostService postService;
    private final TimeTableService timeTableService;
    private final WeekDataService weekDataService;

    public DataBaseController() {
        this.memberService = new MemberService();
        this.attendanceStatusService = new AttendanceStatusService();
        this.managementService = new ManagementService();
        this.memberPortFolioService = new MemberPortFolioService();
        this.postService = new PostService();
        this.timeTableService = new TimeTableService();
        this.weekDataService = new WeekDataService();
    }

    public List<Member> findAllMember() {
        return memberService.findAll();
    }

    public List<AttendanceStatus> findAllAttendanceStatus() {
        return attendanceStatusService.findAll();
    }

    public List<Management> findAllManagement() {
        return managementService.findAll();
    }

    public List<MemberPortfolio> findAllMemberPortfolio() {
        return memberPortFolioService.findAll();
    }

    public List<Post> findAllPost() {
        return postService.findAll();
    }

    public List<TimeTable> findAllTimeTAble() {
        return timeTableService.findAll();
    }

    public List<WeekData> findAllWeekData() {
        return weekDataService.findAll();
    }
}
