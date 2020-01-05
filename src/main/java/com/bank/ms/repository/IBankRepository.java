package com.bank.ms.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bank.ms.model.BankEntity;

@Repository
public interface IBankRepository extends ReactiveMongoRepository<BankEntity,String>{

}
