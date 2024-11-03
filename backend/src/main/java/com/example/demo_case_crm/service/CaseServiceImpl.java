package com.example.demo_case_crm.service;

import com.example.demo_case_crm.entity.Case;
import com.example.demo_case_crm.repository.CaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaseServiceImpl implements CaseService{

    private CaseRepository caseRepository;

    public CaseServiceImpl(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    @Override
    public List<Case> getAll() {
        return caseRepository.findAll();
    }
}