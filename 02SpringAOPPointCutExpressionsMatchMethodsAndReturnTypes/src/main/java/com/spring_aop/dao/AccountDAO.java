package com.spring_aop.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING ACCOUNT");
	}
	
	public boolean addSillyAccount() {
		System.out.println(getClass()+": DOING STUFF: ADDING SILLY ACCOUNT");
		return true;
	}
	
}
