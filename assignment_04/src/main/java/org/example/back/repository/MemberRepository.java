package org.example.back.repository;

import org.example.back.entity.Member;
import org.example.back.database.Database;
import org.example.back.domain.Application;

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
