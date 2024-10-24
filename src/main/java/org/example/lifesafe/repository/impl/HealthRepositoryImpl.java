package org.example.lifesafe.repository.impl;

import org.example.lifesafe.model.entities.Health;
import org.example.lifesafe.repository.IHealthRepository;
import org.springframework.stereotype.Repository;

@Repository
public class HealthRepositoryImpl extends DefaultRepositoryImpl<Health> implements IHealthRepository {

    public HealthRepositoryImpl() {
        super(Health.class);
    }
}
