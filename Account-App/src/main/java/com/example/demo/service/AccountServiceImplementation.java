package com.example.demo.service;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.springframework.stereotype.Component;

import com.example.demo.Repository.AccountRepository;
import com.example.demo.model.Account;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component(value = "accountService")
public class AccountServiceImplementation implements AccountService {

	private final AccountRepository accountRepository;
	
	@Override
	public Account createAccount(Account account) {
		return accountRepository.createAccount(account);
	}

	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.getAllAccounts();
	}

	@Override
	public Account getAccountByAccountNumber(String accountNumber) throws AccountNotFoundException {
		return accountRepository.getAccountByAccountNumber(accountNumber);
	}

	@Override
	public Account updateAccountByAccountNumber(String accountNumber, Account account) throws AccountNotFoundException {
		return accountRepository.updateAccountByAccountNumber(accountNumber, account);
	}

	@Override
	public void deleteAccount(String accountNumber) throws AccountNotFoundException{
		accountRepository.deleteAccount(accountNumber);
	}

	
}
