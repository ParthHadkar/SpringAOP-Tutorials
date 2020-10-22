package com.spring_aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyApiAnalyticsAspect {

	@Before("com.spring_aop.aspect.SharingPointCutExpressions.forDaoPackageWithOutSetterGetter()")
	public void performApiAnalytics() {
		
		System.out.println("\n ====>>>>: Performing Api Analytics");
	}

}
