package com.spring_aop.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberDAO {
	
	public void addAccount() {
		System.out.println(getClass()+": DOING STUFF: ADDING ACCOUNT");
	}
	
	public void addSillyAccount() {
		System.out.println(getClass()+": DOING STUFF: ADDING SILLY ACCOUNT");
	}
	
	public void memberDetails() {
		System.out.println(getClass()+": DOING STUFF: GETTING MEMBER DETAILS");
	}
}
