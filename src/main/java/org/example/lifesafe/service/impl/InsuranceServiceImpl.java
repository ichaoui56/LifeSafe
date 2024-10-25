package org.example.lifesafe.service.impl;

import org.example.lifesafe.model.entities.Insurance;
import org.example.lifesafe.repository.IInsuranceRepository;
import org.example.lifesafe.service.IInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceServiceImpl implements IInsuranceService {

    private final IInsuranceRepository insuranceRepository;

    @Autowired
    public InsuranceServiceImpl(IInsuranceRepository insuranceRepository){
        this.insuranceRepository = insuranceRepository;
    }

    @Override
    public void addInsurance(Insurance insurance){
        insuranceRepository.create(insurance);
    }
}
