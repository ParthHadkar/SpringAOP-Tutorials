package com.spring_aop.main;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring_aop.config.SpringConfig;
import com.spring_aop.dao.AccountDAO;
import com.spring_aop.dao.MemberDAO;
import com.spring_aop.model.Account;
import com.spring_aop.service.TrafficFortuneService;

public class MainFortuneDemoApp {

	private static Logger myLogger = Logger.getLogger(MainFortuneDemoApp.class.getName());

	
	public static void main(String[] args) {
		
		// read the spring config class/open the context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
		// get the bean from spring container
		TrafficFortuneService trafficFortuneService = context.getBean("trafficFortuneService",TrafficFortuneService.class);
		myLogger.info("\n ====>>>> In Main Method \n");
		myLogger.info(" Executing getFortune() ");
		String fortune = trafficFortuneService.getFortune();
		myLogger.info("Todays fortune: "+fortune);
		myLogger.info("\n ====>>>> Finished ");
		// close the context
		context.close();
	}

}
