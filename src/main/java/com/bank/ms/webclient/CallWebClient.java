package com.bank.ms.webclient;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.bank.ms.model.CurrentEntity;
import com.bank.ms.model.EntityBusinessCredit;
import com.bank.ms.model.EntityCreditCard;
import com.bank.ms.model.EntityCreditPersonal;
import com.bank.ms.model.EntityDebtor;
import com.bank.ms.model.EntityTransaction;
import com.bank.ms.model.InfoResponse;
import com.bank.ms.model.SavingEntity;
import com.bank.ms.service.IDebtorService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Qualifier("webClient")
public  class CallWebClient {
	String msg = "";
	
	@Autowired
	IDebtorService service;
	
	EntityDebtor entityDebtor;
	InfoResponse  response;
	  WebClient client = WebClient.builder().baseUrl("http://gateway:8881")
			  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	  
  public Mono<EntityDebtor> Response(List<String> numDoc){
	  msg = "";  
		response = new InfoResponse();
		entityDebtor = new EntityDebtor();
		response.setMsg("");
			  return    client.post().uri("/credit-card/api/creditCardByNumDocList/0").syncBody(numDoc)
						.retrieve().bodyToFlux(EntityCreditCard.class).collectList().flatMap(card -> {
								if(card.size() > 0) {
								msg= " DEUDA EN TARJETA DE CREDITO ";
								 response.setMsg(msg);
								}
								return Mono.just(entityDebtor);
				
					}).switchIfEmpty(Mono.just(entityDebtor)).flatMap(p4->{
						
						return  client.post().uri("/personal-credit/api/creditPersonalByNumDocList/0").syncBody(numDoc)
								.retrieve().bodyToFlux(EntityCreditPersonal.class).collectList().flatMap(creditPer -> {
									if(creditPer.size() > 0) {		
									msg += "- DEUDA EN CREDITO PERSONA ";
									response.setMsg(msg);
									}
									return Mono.just(entityDebtor);
								});
						
							}).switchIfEmpty(Mono.just(entityDebtor)).flatMap(p5->{
								
								return  client.post().uri("/business-credit/api/creditBusinessByNumDocList/0").syncBody(numDoc)
										.retrieve().bodyToFlux(EntityBusinessCredit.class).collectList().flatMap(creditBusi -> {	
											if(creditBusi.size() > 0) {
												msg += " - DEUDA EN CREDITO EMPRESA ";									
											 	response.setMsg(msg);
											}
											
											if(!msg.equals("")) {
												entityDebtor.setNumDoc(numDoc);
												entityDebtor.setMsj(msg);
												entityDebtor.setStatus("0");
											}
											return Mono.just(entityDebtor);
									}).switchIfEmpty(Mono.just(entityDebtor));
		
							});			
	  }

  
  		public Flux<EntityCreditPersonal> getCreditPersonal(){
  			return  client.get().uri("/personal-credit/api/getCreditPersonal")
			.retrieve().bodyToFlux(EntityCreditPersonal.class).filter( p -> p.getStatus().equals("1"));	
  		}
  		
  	
  		public Mono<EntityCreditPersonal> putCreditPersonal(EntityCreditPersonal body){
  			return  client.put().uri("/personal-credit/api/postCreditPersonal").syncBody(body)
			.retrieve().bodyToMono(EntityCreditPersonal.class);	
  		}
  		

  		public Mono<EntityTransaction> postTransacction(String typeAccount,String type,String numAccount,Double cash){
  			return  client.post().uri("/transactions/api/transactions/"+numAccount+"/"+type+"/"+cash+"/"+typeAccount)
			.retrieve().bodyToMono(EntityTransaction.class);	
  		}

		
  		public Mono<SavingEntity> getSaving(String numAccount){
  			return  client.get().uri("/saving-account/api/getSaving/"+numAccount)
  					.retrieve().bodyToMono(SavingEntity.class);	
  		}
  		
  		public Mono<CurrentEntity> getCurrent(String numAccount){
  			return  client.get().uri("/current-account/api/getCurrentNumAcc/"+numAccount)
  					.retrieve().bodyToMono(CurrentEntity.class);	
  		}
}
