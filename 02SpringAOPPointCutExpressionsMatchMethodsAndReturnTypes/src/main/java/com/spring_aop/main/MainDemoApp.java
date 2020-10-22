package com.spring_aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_aop.config.SpringConfig;
import com.spring_aop.dao.AccountDAO;
import com.spring_aop.dao.MemberDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read the spring config class/open the context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		MemberDAO memberDAO = context.getBean("memberDAO",MemberDAO.class);
		
		// get the accountDAO business method
		accountDAO.addAccount();
		accountDAO.addSillyAccount();
		
		// get the memberDAO business method 
		memberDAO.addAccount();
		memberDAO.addSillyAccount();
		
		// close the context
		context.close();
	}

}
