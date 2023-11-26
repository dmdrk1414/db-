package org.example.database;

import lombok.Getter;
import org.example.domain.Application;
import org.example.dto.request.SavePostRequest;
import org.example.entity.*;

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
        return new DBManagement(dbStatement).findAll();
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
        return new DBTimeTable(dbStatement).findAll();
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

    public boolean updateAttendanceStatus(Integer id) {
        return new DBAttendanceStatus(dbStatement, connection).updateAttendanceStatus(id);
    }

    public Boolean updateWeekDate(Integer memberId) {
        return new DBWeekData(dbStatement, connection).updateWeekDate(memberId);
    }

    public boolean savePost(SavePostRequest savePostRequest) {
        return new DBPost(dbStatement, connection).save(savePostRequest);
    }
}
