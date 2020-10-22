package com.spring_aop.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	// Apply @Around Advice to getFortune()
	@Around("execution(* com.spring_aop.service.*.getFortune(..))")
	public Object aroundGetFortuneAdvice(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable{

		// print out which method we are advising on
		String methodName = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n ====>>>>: Executing @Around advice on method: "+methodName);
		// get start timeStamp
		long start = System.currentTimeMillis();
		// execute the method
		Object result = null;
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Throwable e) {
			//e.printStackTrace();
			// log exception
			myLogger.warning("\n ====>>>>: Exception Occur : "+e.getMessage());
			throw e;
		}
		// get end timeStamp
	    long end = System.currentTimeMillis();
	    // compute the duration and display it
	    long duration = end - start;
	    myLogger.info("\n ====>>>>:Duration: "+(duration / 1000.0)+" seconds");
	    return result;
	} 
	
	// Apply @After (finally)Advice to findAccounts()
	@After("execution(* com.spring_aop.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		
		// print out which method we are advising on
		String methodName = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ====>>>>: Executing @After (finally) advice on method: "+methodName);
	}
	
	// Apply @AfterThrowing Advice To findAccounts()
	@AfterThrowing(
			pointcut = "execution(* com.spring_aop.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc"
			)
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint,Throwable theExc) {
		
		// print out which method we are advising on
		String methodName = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n ====>>>>: Executing @AfterReturning advice on method: "+methodName);
		// log the exception
		myLogger.info("\n ====>>>>: The exception is: "+theExc);
	}
	
	// Apply @AfterReturning Advice To findAccounts()
		@AfterReturning(
				pointcut = "execution(* com.spring_aop.dao.AccountDAO.findAccounts(..))",
				returning = "result"
				)
		public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint,List<Account> result) {
			
			// display the method name 
			String methodName = theJoinPoint.getSignature().toShortString();
			myLogger.info("\n ====>>>>: Executing @AfterReturning advice on method: "+methodName);
			// print out the result on method call
			myLogger.info("\n ====>>>>:orignal result: "+result);
			//let pre-process the data .... let's modified it
			//convert the account name to uppercase
			convertAccountNameToUpperCase(result);
			myLogger.info("\n ====>>>>:modified result: "+result);
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
		
		myLogger.info("\n ====>>>>: Executing @Before advice on method");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("MethodSignature: "+methodSig);
		// display the method arguments
		
		// get args
		Object[] args = theJoinPoint.getArgs();
		// loop through args
		for(Object tempArg:args) {
			myLogger.info("tempArg: "+tempArg);
			if(tempArg instanceof Account) {
				
				// downcast and print Account specific stuff
				Account myAccount = (Account) tempArg;
				myLogger.info("Account Name  : "+myAccount.getName());
				myLogger.info("Account Level : "+myAccount.getLevel());
			}
		}
	}
	
	
}
