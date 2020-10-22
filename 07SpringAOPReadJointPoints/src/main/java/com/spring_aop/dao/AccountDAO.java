package com.spring_aop.dao;

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
