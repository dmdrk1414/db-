//package org.example.delete.back.repository;
//
//import org.example.delete.back.database.DatabaseDelete;
//import org.example.delete.back.domain.Application;
//import org.example.delete.back.entity.AttendanceStatus;
//
//import java.util.List;
//
//public class AttendanceStatusRepository {
//    private final DatabaseDelete database;
//
//    public AttendanceStatusRepository() {
//        this.database = new DatabaseDelete();
//    }
//
//    public List<AttendanceStatus> findAll() {
//        return database.findAllAttendanceStatus();
//    }
//
//    public boolean save(Application application) {
//        return database.saveAttendanceStatus(application);
//    }
//
//    public boolean updateAttendanceStatus(Integer memberId) {
//        return database.updateAttendanceStatus(memberId);
//    }
//}
