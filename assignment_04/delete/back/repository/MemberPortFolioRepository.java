package org.example.delete.back.repository;

import org.example.delete.back.database.DatabaseDelete;
import org.example.delete.back.domain.Application;
import org.example.delete.back.entity.MemberPortfolio;

import java.util.List;

public class MemberPortFolioRepository {
    private final DatabaseDelete database;

    public MemberPortFolioRepository() {
        this.database = new DatabaseDelete();
    }

    public List<MemberPortfolio> findAll() {
        return database.findAllMemberPortfolio();
    }

    public Boolean save(Application application) {
        return database.saveMemberPortFolio(application);
    }
}
