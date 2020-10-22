package com.spring_aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_aop.config.SpringConfig;
import com.spring_aop.dao.AccountDAO;
import com.spring_aop.dao.MemberDAO;
import com.spring_aop.model.Account;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read the spring config class/open the context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		MemberDAO memberDAO = context.getBean("memberDAO",MemberDAO.class);
		
		// get the accountDAO business method
		Account account = new Account();
		account.setName("Parth");
		account.setLevel("Diamond");
		accountDAO.addAccount(account,true);
		accountDAO.addSillyAccount();
		accountDAO.accountDetails();
		
		accountDAO.setName("Parth");
		accountDAO.setServiceCode("Diamond");
		
		String name = accountDAO.getName();
		String serviceCode = accountDAO.getServiceCode();
		
		// get the memberDAO business method 
		memberDAO.addAccount();
		memberDAO.addSillyAccount();
		memberDAO.memberDetails();
		
		// close the context
		context.close();
	}

}
