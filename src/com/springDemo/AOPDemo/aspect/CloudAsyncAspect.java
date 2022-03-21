package com.springDemo.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class CloudAsyncAspect {

	@Before("com.springDemo.AOPDemo.aspect.AopExpressions.allMethodsExceptGetterSetter()")
	public void performCloudLogging() {
		System.out.println("performing cloud logging async .. ");
	}

}
