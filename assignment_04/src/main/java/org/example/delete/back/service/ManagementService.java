package org.example.delete.back.service;

import org.example.delete.back.domain.Application;
import org.example.delete.back.entity.Management;
import org.example.delete.back.repository.ManagementRepository;

import java.util.List;

public class ManagementService {
    private final ManagementRepository managementRepository;

    public ManagementService() {
        this.managementRepository = new ManagementRepository();
    }

    public List<Management> findAll() {
        return managementRepository.findAll();
    }

    public boolean save(Application application) {
        return managementRepository.save(application);
    }
}
