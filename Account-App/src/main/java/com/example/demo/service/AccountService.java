package com.example.demo.service;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import com.example.demo.model.Account;

public interface AccountService {
	Account createAccount(Account account);
	List<Account> getAllAccounts();
	Account getAccountByAccountNumber(String accountNumber) throws AccountNotFoundException;
	Account updateAccountByAccountNumber(String accountNumber, Account account) throws AccountNotFoundException;
	void deleteAccount(String accountNumber) throws AccountNotFoundException;
}
