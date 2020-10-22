package com.spring_aop.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	// Apply @AfterThrowing Advice To findAccounts()
	@AfterThrowing(
			pointcut = "execution(* com.spring_aop.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc"
			)
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint,Throwable theExc) {
		
		// print out which method we are advising on
		String methodName = theJoinPoint.getSignature().toShortString();
		System.out.println("\n ====>>>>: Executing @AfterReturning advice on method: "+methodName);
		// log the exception
		System.out.println("\n ====>>>>: The exception is: "+theExc);
	}
	
	// Apply @AfterReturning Advice To findAccounts()
		@AfterReturning(
				pointcut = "execution(* com.spring_aop.dao.AccountDAO.findAccounts(..))",
				returning = "result"
				)
		public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint,List<Account> result) {
			
			// display the method name 
			String methodName = theJoinPoint.getSignature().toShortString();
			System.out.println("\n ====>>>>: Executing @AfterReturning advice on method: "+methodName);
			// print out the result on method call
			System.out.println("\n ====>>>>:orignal result: "+result);
			//let pre-process the data .... let's modified it
			//convert the account name to uppercase
			convertAccountNameToUpperCase(result);
			System.out.println("\n ====>>>>:modified result: "+result);
		}

		private void convertAccountNameToUpperCase(List<Account> result) {
			// looping through account
			for(Account tempAccount:result) {
				// get uppercase version
				String accountNameUP = tempAccount.getName().toUpperCase();
				// update the account name  
				tempAccount.setName(accountNameUP);
			}
		}
		
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
