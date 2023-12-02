package org.example.delete.back.repository;

import org.example.delete.back.entity.Member;
import org.example.delete.back.database.Database;
import org.example.delete.back.domain.Application;

import java.util.List;

public class MemberRepository {
    private final Database database;

    public MemberRepository() {
        this.database = new Database();
    }

    public List<Member> findAll() {
        return database.findAllMember();
    }

    public Boolean save(Application application) {
        return database.saveMember(application);
    }

    public Member findByEmail(String email) {
        return database.findByEmailMember(email);
    }
}
