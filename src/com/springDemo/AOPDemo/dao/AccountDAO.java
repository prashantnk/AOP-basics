package com.springDemo.AOPDemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springDemo.AOPDemo.Account;

@Component
public class AccountDAO {

	private String name, number;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public void addAccount() {
		System.out.println(getClass() + " : Adding account !");
	}

	public void addAccount(Account a, boolean vip) {
		System.out.println(getClass() + " : Adding account ! : " + a + " , vip : " + vip);
	}

	public List<Account> findAccounts(boolean throwException) {

		if (throwException) {
			throw new RuntimeException("hello , here's your new runtime exception!!");
		}

		List<Account> acc = new ArrayList<Account>();

//		add sample values 

		Account a = new Account(1, "Prashant");
		Account b = new Account(2, "Ranjan");

		acc.add(a);
		acc.add(b);

		return acc;
	}

}
