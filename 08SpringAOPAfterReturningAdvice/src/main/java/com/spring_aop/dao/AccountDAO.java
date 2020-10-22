package com.spring_aop.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.spring_aop.model.Account;

@Component
public class AccountDAO {
	
	private String name;
	private String serviceCode;
	
	

	public void addAccount(Account account,boolean vipFlag) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING ACCOUNT");
	}
	
	public boolean addSillyAccount() {
		System.out.println(getClass()+": DOING STUFF: ADDING SILLY ACCOUNT");
		return true;
	}
	
	public void accountDetails() {
		System.out.println(getClass()+": DOING STUFF: GETTING ACCOUNT DETAILS");
	}
	
	// Add a new method: findAccounts()
	public List<Account> findAccounts(){
		
		//Create demo Account list
		List<Account> accounts = new ArrayList<Account>();
		//Create a sample account
		Account account1 = new Account("Parth", "Diamond");
		Account account2 = new Account("Nikhil", "Diamond");
		Account account3 = new Account("Omkar", "Diamond");
		Account account4 = new Account("Siddhesh", "Diamond");
		//Add it to demo account list
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		accounts.add(account4);
		return accounts;
	} 

	public String getName() {
		System.out.println(getClass()+": IN getName");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass()+": IN setName");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass()+": IN getServiceCode");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass()+": IN setServiceCode");
		this.serviceCode = serviceCode;
	}
	
	
}
