package com.girish.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import com.girish.service.EmployeeClientService;

@Configuration
public class WebConfig {
	
	@Bean
	WebClient  webClient() {		
		return WebClient.builder()
				        .baseUrl("http://localhost:8001/")
				        .build();
		
	}
	
	@Bean
	EmployeeClientService postClient(WebClient webClient) { 
		HttpServiceProxyFactory httpServiceProxyFactory=HttpServiceProxyFactory.builderFor(WebClientAdapter.create(webClient))
	            .build();
		return httpServiceProxyFactory.createClient(EmployeeClientService.class);
	}

}
