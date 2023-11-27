package org.example.back.repository;

import org.example.back.entity.MemberPortfolio;
import org.example.back.database.Database;
import org.example.back.domain.Application;

import java.util.List;

public class MemberPortFolioRepository {
    private final Database database;

    public MemberPortFolioRepository() {
        this.database = new Database();
    }

    public List<MemberPortfolio> findAll() {
        return database.findAllMemberPortfolio();
    }

    public Boolean save(Application application) {
        return database.saveMemberPortFolio(application);
    }
}