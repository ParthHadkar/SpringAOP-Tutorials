package com.spring_aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class SharingPointCutExpressions {
	
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
	
}
