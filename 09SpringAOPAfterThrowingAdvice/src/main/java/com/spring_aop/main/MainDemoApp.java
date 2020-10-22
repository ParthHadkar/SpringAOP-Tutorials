package com.spring_aop.main;

import java.util.List;

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
		
		List<Account> accounts = null;
		try {
			boolean tripWire = true;
			accounts = accountDAO.findAccounts(tripWire);
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("\n====>>>>: Exception occur in main method "+e);
		}
		// display the accounts
		System.out.println("---->\n Displaying the accounts");
		System.out.println(accounts);
		System.out.println("---->\n Accounts Displayed");
		// close the context
		context.close();
	}

}
