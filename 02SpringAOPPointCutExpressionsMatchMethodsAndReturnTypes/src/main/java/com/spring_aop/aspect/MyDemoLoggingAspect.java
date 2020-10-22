package com.spring_aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advices for logging
	
	// let's start witn an @Before advice
	 /** matching by same methodName */
	//@Before("execution(public void addAccount())")
	/** matching by class declaration */
	//@Before("execution(public void com.spring_aop.dao.AccountDAO.addAccount() )") 
	/** matching by wildCard (any add* method) */
	//@Before("execution(public void add*())") 
	/** matching by wildCard (any returnType with any add* method) */
	@Before("execution(* add*())") 
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n ====>>>>: Executing @Before advice on method");
	}
}
