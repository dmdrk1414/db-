package org.example.database;

import lombok.Getter;
import org.example.domain.*;

import java.sql.Statement;
import java.util.List;

@Getter
public class Database {
    private final Statement dbStatement;

    public Database() {
        this.dbStatement = new DBConnection().getStatement();
    }

    public List<AttendanceStatus> findAllAttendanceStatus() {
        return new DBAttendanceStatus(dbStatement).findAll();
    }

    public List<Management> findAllManagement() {
        return new DBManagement(dbStatement).findAll();
    }

    public List<Member> findAllMember() {
        return new DBMember(dbStatement).findAll();
    }

    public List<MemberPortfolio> findAllMemberPortfolio() {
        return new DBMemberPortfolio(dbStatement).findAll();
    }

    public List<Post> findAllPost() {
        return new DBPost(dbStatement).findAll();
    }

    public List<TimeTable> findAllTimeTable() {
        return new DBTimeTable(dbStatement).findAll();
    }

    public List<WeekData> findAllWddkData() {
        return new DBWeekData(dbStatement).findAll();
    }
}
