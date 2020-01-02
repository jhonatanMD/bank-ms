package com.bank.ms.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.bank.ms.model.EntityDebtor;

@Repository
public interface IRepositoryDebtor extends ReactiveMongoRepository<EntityDebtor, String> {

}
