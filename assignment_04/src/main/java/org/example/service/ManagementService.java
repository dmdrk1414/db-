package org.example.service;

import org.example.entity.Management;
import org.example.repository.ManagementRepository;

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
