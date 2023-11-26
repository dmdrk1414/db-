package org.example.repository;

import org.example.database.Database;
import org.example.domain.Application;
import org.example.entity.Member;

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
