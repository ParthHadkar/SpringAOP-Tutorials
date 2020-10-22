package com.spring_aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.spring_aop.model.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
		
	@Before("com.spring_aop.aspect.SharingPointCutExpressions.forDaoPackageWithOutSetterGetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n ====>>>>: Executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("MethodSignature: "+methodSig);
		// display the method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		// loop through args
		for(Object tempArg:args) {
			System.out.println("tempArg: "+tempArg);
			if(tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account myAccount = (Account) tempArg;
				System.out.println("Account Name  : "+myAccount.getName());
				System.out.println("Account Level : "+myAccount.getLevel());
			}
		}
	}
	
}
