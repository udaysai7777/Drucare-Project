package com.Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
@PropertySource("classpath:application.properties")
@SpringBootApplication
public class BankInfoApplication {
	
public static void main(String[] args) {
		SpringApplication.run(BankInfoApplication.class, args);
		
}
@Bean
public RestTemplate getRestTemplate() {
	return new RestTemplate();
}
}