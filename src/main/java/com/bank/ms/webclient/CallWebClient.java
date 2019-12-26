package com.bank.ms.webclient;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import com.bank.ms.model.EntityBusinessCredit;
import com.bank.ms.model.EntityCreditCard;
import com.bank.ms.model.EntityCreditPersonal;
import com.bank.ms.model.InfoResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@Qualifier("webClient")
public class CallWebClient {
	String msg = "";
	
	  WebClient client = WebClient.builder().baseUrl("http://localhost:8010")
			  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	  
	  
	  
  public Mono<InfoResponse> Response(String numDoc){
		  
		InfoResponse  response = new InfoResponse();
	
			  return    client.get().uri("/credit-card/api/getCreditCardNumDoc/"+numDoc)
						.retrieve().bodyToFlux(EntityCreditCard.class).collectList().flatMap(card -> {
							card.forEach(p ->{
								if(p.getCustomer().getDniH().equals(numDoc)  && p.getStatus().equals("0")) {
									msg= " DEUDA EN TARJETA DE CREDITO ";
								}
							});
								 response.setMsg(msg);
								return Mono.just(response);
				
					}).switchIfEmpty(Mono.just(response)).flatMap(p4->{
						
						return  client.get().uri("/personal-credit/api/getCreditPersonalNumDoc/"+numDoc)
								.retrieve().bodyToFlux(EntityCreditPersonal.class).collectList().flatMap(creditPer -> {
									creditPer.forEach(dt ->{
										if(dt.getCustomer().getDniH().equals(numDoc)  && dt.getStatus().equals("0")) {
											msg += "- DEUDA EN CREDITO PERSONA ";
										}
									});
									response.setMsg(msg);
									return Mono.just(response);
								});
						
							}).switchIfEmpty(Mono.just(response)).flatMap(p5->{
								
								return  client.get().uri("/business-credit/api/getBusinessCrediDoc/"+numDoc)
										.retrieve().bodyToFlux(EntityBusinessCredit.class).collectList().flatMap(creditBusi -> {
											creditBusi.forEach(dt ->{
												if(dt.getCustomer().getRuc().equals(numDoc)  && dt.getStatus().equals("0")) {
													msg += " - DEUDA EN CREDITO EMPRESA ";
												}
											});
											 	response.setMsg(msg);
												return Mono.just(response);
									}).switchIfEmpty(Mono.just(response));
		
							});				
	  }

  
  public Flux<EntityCreditCard> getCreditPersonalByNumDoc(String numDoc){
		return  client.get().uri("/api/getCreditCardNumDoc/"+numDoc)
			.retrieve().bodyToFlux(EntityCreditCard.class);	
	  }
}
