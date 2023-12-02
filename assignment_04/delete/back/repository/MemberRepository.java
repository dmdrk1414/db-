package org.example.delete.back.repository;

import org.example.delete.back.database.DatabaseDelete;
import org.example.delete.back.domain.Application;
import org.example.delete.back.entity.Member;

import java.util.List;

public class MemberRepository {
    private final DatabaseDelete database;

    public MemberRepository() {
        this.database = new DatabaseDelete();
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
