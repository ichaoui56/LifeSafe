package org.example.lifesafe.service.impl;

import org.example.lifesafe.model.entities.Contract;
import org.example.lifesafe.repository.IContractRepository;
import org.example.lifesafe.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements IContractService {
    private IContractRepository contractRepository;

    @Autowired
    public ContractServiceImpl(IContractRepository contractRepository){
        this.contractRepository = contractRepository;
    }

    @Override
    public void addContract(Contract contract){
        contractRepository.create(contract);
    }
}
