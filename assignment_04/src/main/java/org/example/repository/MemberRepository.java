package org.example.repository;

import org.example.database.Database;
import org.example.domain.Member;
import org.example.domain.MemberPortfolio;

import java.util.List;

public class MemberRepository {
    private final Database database;

    public MemberRepository() {
        this.database = new Database();
    }

    public List<Member> findAll() {
        return database.findAllMember();
    }
}
