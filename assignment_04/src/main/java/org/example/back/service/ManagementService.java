package org.example.back.service;

import org.example.back.entity.Management;
import org.example.back.repository.ManagementRepository;

import java.util.List;

public class ManagementService {
    private final ManagementRepository managementRepository;

    public ManagementService() {
        this.managementRepository = new ManagementRepository();
    }

    public List<Management> findAll() {
        return managementRepository.findAll();
    }
}
