package com.bank.ms.webclient;

import java.util.List;

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
	
	  WebClient client = WebClient.builder().baseUrl("http://localhost:8881")
			  .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	  
	  
	  
  public Mono<InfoResponse> Response(List<String> numDoc){
	  msg = "";  
		InfoResponse  response = new InfoResponse();
		response.setMsg("");
			  return    client.post().uri("/credit-card/api/creditCardByNumDocList/0").syncBody(numDoc)
						.retrieve().bodyToFlux(EntityCreditCard.class).collectList().flatMap(card -> {
								if(card.size() > 0) {
								msg= " DEUDA EN TARJETA DE CREDITO ";
								 response.setMsg(msg);
								}
								return Mono.just(response);
				
					}).switchIfEmpty(Mono.just(response)).flatMap(p4->{
						
						return  client.post().uri("/personal-credit/api/creditPersonalByNumDocList/0").syncBody(numDoc)
								.retrieve().bodyToFlux(EntityCreditPersonal.class).collectList().flatMap(creditPer -> {
									if(creditPer.size() > 0) {		
									msg += "- DEUDA EN CREDITO PERSONA ";
									response.setMsg(msg);
									}
									return Mono.just(response);
								});
						
							}).switchIfEmpty(Mono.just(response)).flatMap(p5->{
								
								return  client.post().uri("/business-credit/api/creditBusinessByNumDocList/0").syncBody(numDoc)
										.retrieve().bodyToFlux(EntityBusinessCredit.class).collectList().flatMap(creditBusi -> {	
											if(creditBusi.size() > 0) {
												msg += " - DEUDA EN CREDITO EMPRESA ";									
											 	response.setMsg(msg);
											}
												return Mono.just(response);
									}).switchIfEmpty(Mono.just(response));
		
							});				
	  }

  
  public Flux<EntityCreditCard> getCreditPersonalByNumDoc(String numDoc){
		return  client.get().uri("/api/getCreditCardNumDoc/"+numDoc)
			.retrieve().bodyToFlux(EntityCreditCard.class);	
	  }
}
