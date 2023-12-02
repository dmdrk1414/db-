package org.example.delete.back.service;

import org.example.delete.back.domain.Application;
import org.example.delete.back.entity.MemberPortfolio;
import org.example.delete.back.repository.MemberPortFolioRepository;

import java.util.List;

public class MemberPortFolioService {
    private final MemberPortFolioRepository memberPortFolioRepository;

    public MemberPortFolioService() {
        this.memberPortFolioRepository = new MemberPortFolioRepository();
    }

    public List<MemberPortfolio> findAll() {
        return memberPortFolioRepository.findAll();
    }

    public Boolean save(Application application) {
        return memberPortFolioRepository.save(application);
    }
}
