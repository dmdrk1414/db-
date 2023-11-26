package org.example.repository;

import org.example.database.Database;
import org.example.domain.Application;
import org.example.entity.MemberPortfolio;

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
