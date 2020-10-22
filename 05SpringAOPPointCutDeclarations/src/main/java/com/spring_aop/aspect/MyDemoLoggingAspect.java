package com.spring_aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.spring_aop.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// PointCut Expression to get all setter method in this package
	@Pointcut("execution(* com.spring_aop.dao.*.set*(..))")
	public void setter() {}
	
	// PointCut Expression to get all getter method in this package
	@Pointcut("execution(* com.spring_aop.dao.*.get*(..))")
	public void getter() {}
	
	// PointCut Expression to include forDaoPackage() and exclude setter and getter method
	@Pointcut("forDaoPackage() && !(setter() || getter())")
	public void forDaoPackageWithOutSetterGetter() {}
	
	@Before("forDaoPackageWithOutSetterGetter()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n ====>>>>: Executing @Before advice on method");
	}
	
	@Before("forDaoPackageWithOutSetterGetter()")
	public void performApiAnalytics() {
		
		System.out.println("\n ====>>>>: Performing Api Analytics");
	}
}
