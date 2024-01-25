package com.example.demo;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import com.example.demo.Repository.AccountRepository;
import com.example.demo.model.Account;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@SpringBootApplication
@EnableDiscoveryClient
public class AccountAppApplication {
	private final AccountRepository accountRepository;
	public static void main(String[] args) {
		SpringApplication.run(AccountAppApplication.class, args);
	}
	
	@PostConstruct
	public void init() throws Exception {
//		accountRepository.createAccount(new Account(UUID.randomUUID().toString(), "Ankur", "Kolkata","ankur@gmail.com"));
		List<Account> result = Stream
				.of(new Account("1", "Ankur", "Kolkata","ankur@gmail.com"),
						new Account(UUID.randomUUID().toString(), "Adarsh", "Kolkata","Adarsh@gmail.com"),
						new Account(UUID.randomUUID().toString(), "Alka", "Kolkata","Alka@gmail.com"))
				.collect(Collectors.toList());
		for(Account a : result) {
			accountRepository.createAccount(a);
		}
	}
}

