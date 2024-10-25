package org.example.lifesafe.repository.impl;

import org.example.lifesafe.model.entities.Contract;
import org.example.lifesafe.repository.IContractRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ContractRepositoryImpl extends DefaultRepositoryImpl<Contract> implements IContractRepository {

    public ContractRepositoryImpl(){
        super(Contract.class);
    }
}
