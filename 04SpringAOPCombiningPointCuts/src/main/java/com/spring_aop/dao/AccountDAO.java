package com.spring_aop.dao;

import org.springframework.stereotype.Component;

import com.spring_aop.model.Account;

@Component
public class AccountDAO {

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
	
}
