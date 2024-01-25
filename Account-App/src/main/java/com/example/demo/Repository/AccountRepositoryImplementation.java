package com.example.demo.Repository;

import java.util.List;

import javax.security.auth.login.AccountNotFoundException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.model.Account;

import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component(value = "accountRepository")
@EnableTransactionManagement
public class AccountRepositoryImplementation implements AccountRepository {
	
	private final SessionFactory sessionFactory;

	@Override
	@Transactional
	public Account createAccount(Account account) {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.persist(account);
		session.getTransaction().commit();
		return account;
	}

	@Override
	public List<Account> getAllAccounts() {
		Session session = sessionFactory.openSession();
		TypedQuery<Account> query = session.createQuery("FROM Account A", Account.class);
		return query.getResultList();
	}

	@Override
	public Account getAccountByAccountNumber(String accountNumber) throws AccountNotFoundException {
		Session session = sessionFactory.openSession();
		Account account=session.get(Account.class, accountNumber);
		if(account==null)
		{
			throw new AccountNotFoundException("account with "+accountNumber+" not found");
		}
		return account;
	}

	@Override
	public Account updateAccountByAccountNumber(String accountNumber, Account account) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		Account tempAccount = getAccountByAccountNumber(accountNumber);
		if (tempAccount == null) {
			throw new AccountNotFoundException("account with " + accountNumber + " not found");
		}
		Session session = sessionFactory.openSession();
		tempAccount.setAccountHolderName(account.getAccountHolderName());
		tempAccount.setAccountHolderAddress(account.getAccountHolderAddress());
		tempAccount.setEmail(account.getEmail());
		session.getTransaction().begin();
		session.merge(tempAccount);
		session.getTransaction().commit();
		return tempAccount;
	}
	
	@Override
	public void deleteAccount(String accountNumber) throws AccountNotFoundException {
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		Account temp = getAccountByAccountNumber(accountNumber);
		if(temp==null) {
			throw new AccountNotFoundException("account with "+accountNumber+" is not found");
		}
		session.remove(session.merge(temp));
		session.getTransaction().commit();
	}

}
