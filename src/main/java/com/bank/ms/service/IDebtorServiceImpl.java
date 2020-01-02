package com.bank.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.ms.model.EntityDebtor;
import com.bank.ms.repository.IRepositoryDebtor;

import reactor.core.publisher.Mono;

@Service
public class IDebtorServiceImpl implements IDebtorService {

	@Autowired
	IRepositoryDebtor repository;

	@Override
	public Mono<EntityDebtor> saveDebtor(EntityDebtor entityDebtor) {
		// TODO Auto-generated method stub
		return repository.save(entityDebtor);
	}
	
	
}
