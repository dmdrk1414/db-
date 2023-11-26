package org.example.service;

import org.example.domain.Application;
import org.example.entity.MemberPortfolio;
import org.example.repository.MemberPortFolioRepository;

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
