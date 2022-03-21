package com.springDemo.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class ApiAnalyticsAspect {

	@Before("com.springDemo.AOPDemo.aspect.AopExpressions.allMethodsExceptGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("Performing Api Analytics ... ");
	}
}
