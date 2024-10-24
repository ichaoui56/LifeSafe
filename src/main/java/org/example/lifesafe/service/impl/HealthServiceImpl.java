package org.example.lifesafe.service.impl;

import org.example.lifesafe.model.entities.Health;
import org.example.lifesafe.repository.IHealthRepository;
import org.example.lifesafe.service.IHealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthServiceImpl implements IHealthService {

    private IHealthRepository healthRepository;

    @Autowired
    public HealthServiceImpl(IHealthRepository healthRepository){
        this.healthRepository = healthRepository;
    }

    @Override
    public void addInsurance(Health health){
        healthRepository.create(health);
    }


}
