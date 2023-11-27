package org.example.back.database;

import lombok.Getter;
import org.example.back.dto.request.SavePostRequest;
import org.example.back.dto.request.SaveTimeTableRequest;
import org.example.back.entity.*;
import org.example.back.domain.Application;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

@Getter
public class Database {
    private final Statement dbStatement;
    private final Connection connection;

    public Database() {
        this.dbStatement = new DBConnection().getStatement();
        this.connection = new DBConnection().getConnection();
    }

    public List<AttendanceStatus> findAllAttendanceStatus() {
        return new DBAttendanceStatus(dbStatement, connection).findAll();
    }

    public List<Management> findAllManagement() {
        return new DBManagement(dbStatement, connection).findAll();
    }

    public List<Member> findAllMember() {
        return new DBMember(dbStatement, connection).findAll();
    }

    public List<MemberPortfolio> findAllMemberPortfolio() {
        return new DBMemberPortfolio(dbStatement, connection).findAll();
    }

    public List<Post> findAllPost() {
        return new DBPost(dbStatement, connection).findAll();
    }

    public List<TimeTable> findAllTimeTable() {
        return new DBTimeTable(dbStatement, connection).findAll();
    }

    public List<WeekData> findAllWeekData() {
        return new DBWeekData(dbStatement, connection).findAll();
    }

    public Boolean saveMember(Application application) {
        return new DBMember(dbStatement, connection).save(application);
    }

    public Boolean saveMemberPortFolio(Application application) {
        return new DBMemberPortfolio(dbStatement, connection).save(application);
    }

    public Member findByEmailMember(String email) {
        return new DBMember(dbStatement, connection).findByEmail(email);
    }

    public boolean saveAttendanceStatus(Application application) {
        return new DBAttendanceStatus(dbStatement, connection).save(application);
    }

    public boolean updateAttendanceStatus(Integer memberId) {
        return new DBAttendanceStatus(dbStatement, connection).updateAttendanceStatus(memberId);
    }

    public Boolean updateWeekDate(Integer memberId) {
        return new DBWeekData(dbStatement, connection).updateWeekDate(memberId);
    }

    public boolean savePost(SavePostRequest savePostRequest) {
        return new DBPost(dbStatement, connection).save(savePostRequest);
    }

    public boolean deleteByPostId(Integer postId) {
        return new DBPost(dbStatement, connection).deleteByPostId(postId);
    }

    public boolean saveTimeTable(SaveTimeTableRequest saveTimeTableRequest) {
        return new DBTimeTable(dbStatement, connection).save(saveTimeTableRequest);
    }

    public boolean deleteById(Integer tableId) {
        return new DBTimeTable(dbStatement, connection).deleteById(tableId);
    }

    public boolean saveWeekDate(Application application) {
        return new DBWeekData(dbStatement, connection).save(application);
    }

    public boolean saveManagement(Application application) {
        return new DBManagement(dbStatement, connection).save(application);
    }
}
