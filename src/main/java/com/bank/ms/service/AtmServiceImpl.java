package com.bank.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.bank.ms.model.AtmEntity;
import com.bank.ms.repository.IAtmRepository;
import com.bank.ms.webclient.CallWebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class AtmServiceImpl implements IAtmService {
	
	@Autowired
	IAtmRepository repository;
	
	AtmEntity atm;
	Double commi;
	@Autowired
	@Qualifier("webClient")
	CallWebClient client;
	
	@Override
	public Flux<AtmEntity> findAllAtm() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mono<AtmEntity> updAtm(AtmEntity atm) {
		// TODO Auto-generated method stub
		return repository.save(atm);
	}



	@Override
	public Mono<AtmEntity> saveAtm(String typeAccount,String numAccount,String type, String bank,Double cash) {
		// TODO Auto-generated method stub
		atm = new AtmEntity();
		commi = 0.0;
		atm.setMsj("No se encontro cuenta");
		if(typeAccount.equals("SA")) {
			
			return client.getSaving(numAccount).flatMap(saving ->{
				if(!saving.getBank().equals(bank))
				{
					commi = 5.0;
				}				
				return client.postTransacction(typeAccount, type, numAccount, cash + commi).flatMap(x -> {
					/*atm.setBank(saving.getBank());
					atm.setDate(new Date());
					atm.setNumAccount(numAccount);
					if()
					atm.setNumMov(atm.ge);*/
					atm.setMsj("realizado");
					return Mono.just(atm);
					
				});
			}).switchIfEmpty(Mono.just(atm));
		
		}else if(typeAccount.equals("CA")) {
			return Mono.just(atm);
		}else {
			return Mono.just(atm);
		}
	}

}
