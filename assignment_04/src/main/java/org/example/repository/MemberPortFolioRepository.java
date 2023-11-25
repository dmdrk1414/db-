package org.example.repository;

import org.example.database.Database;
import org.example.domain.Management;
import org.example.domain.MemberPortfolio;

import java.util.List;

public class MemberPortFolioRepository {
    private final Database database;

    public MemberPortFolioRepository() {
        this.database = new Database();
    }

    public List<MemberPortfolio> findAll() {
        return database.findAllMemberPortfolio();
    }
}
