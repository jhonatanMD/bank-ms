package com.bank.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.ms.model.BankEntity;
import com.bank.ms.repository.IBankRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class BankServiceImpl implements IBankService{

	@Autowired
	IBankRepository repository;
	@Override
	public Flux<BankEntity> findAllBank() {
		return repository.findAll();
	}

	@Override
	public Mono<BankEntity> saveBank(BankEntity bank) {
		// TODO Auto-generated method stub
		return repository.save(bank);
	}

	@Override
	public Mono<BankEntity> upd(BankEntity bank) {
		// TODO Auto-generated method stub
		return repository.save(bank);
	}

}
