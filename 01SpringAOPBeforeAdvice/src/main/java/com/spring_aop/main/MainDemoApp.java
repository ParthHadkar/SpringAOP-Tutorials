package com.spring_aop.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_aop.config.SpringConfig;
import com.spring_aop.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read the spring config class/open the context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		// get the bean from spring container
		AccountDAO accountDAO = context.getBean("accountDAO",AccountDAO.class);
		// get the business method
		accountDAO.addAccount();
		
		System.out.println("\n Let call it again \n");
		// get the business method again
		accountDAO.addAccount();
		
		// close the context
		context.close();
	}

}
