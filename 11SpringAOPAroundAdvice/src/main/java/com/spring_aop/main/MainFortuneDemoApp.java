package com.spring_aop.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_aop.config.SpringConfig;
import com.spring_aop.dao.AccountDAO;
import com.spring_aop.dao.MemberDAO;
import com.spring_aop.model.Account;
import com.spring_aop.service.TrafficFortuneService;

public class MainFortuneDemoApp {

	public static void main(String[] args) {
		
		// read the spring config class/open the context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		// get the bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		System.out.println("\n ====>>>> In Main Method \n");
		System.out.println(" Executing getFortune() ");
		String fortune = trafficFortuneService.getFortune();
		System.out.println("Todays fortune: "+fortune);
		System.out.println("\n ====>>>> Finished ");
		// close the context
		context.close();
	}

}
