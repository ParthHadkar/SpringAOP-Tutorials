package com.spring_aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// this is where we add all of our related advices for logging
	
	// let's start witn an @Before advice
	/** matching by wildCard and parameter type (any returnType with any add* method and fully qualified
	  parameter type account)*/
	//@Before("execution(* add*(com.spring_aop.model.Account))") 
	/** matching by wildCard and parameter type  (any returnType with any add* method and fully qualified 
	 parameter type account,any one parameter type)*/
	//@Before("execution(* add*(com.spring_aop.model.Account,*))")
	/** matching by wildCard and parameter type  (any returnType with any add* method and fully qualified
	  parameter type account,any 0 to more parameter type)*/
	//@Before("execution(* add*(com.spring_aop.model.Account,..))")
	/** matching by wildCard and parameter type (any returnType with any add* method and any 0 to more
	  parameter type)*/
	//@Before("execution(* add*(..))")
	/** matching by wildCard and package (any returnType with any class* and any method* and
	  any 0 to more parameter type in that package)*/
	@Before("execution(* com.spring_aop.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n ====>>>>: Executing @Before advice on method");
	}
}
