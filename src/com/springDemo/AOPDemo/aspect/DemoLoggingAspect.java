package com.springDemo.AOPDemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springDemo.AOPDemo.Account;

@Aspect
@Component
@Order(3)
public class DemoLoggingAspect {

//	it will have all the advice related to logging

//	start with @Before

//	Match methods and return types

//	@Before("execution(public void addAccount())")
//	@Before("execution(public void add*())")
//	@Before("execution(void add*())")
//	@Before("execution(* *())")
//	@Before("execution(public void com.springDemo.AOPDemo.dao.AccountDAO.addAccount())")

//	Match method parameters

//	@Before("execution(void add*(com.springDemo.AOPDemo.Account , *))")
//	@Before("execution(void add*(* , *))")
//	@Before("execution(void add*(com.springDemo.AOPDemo.Account , *))")
//	@Before("execution(void add*(..))")

//	Match any methods on given package of any class

//	@Before("execution(* com.springDemo.AOPDemo.dao.*.*(..))")

//	Point-cut declarations

//	@Pointcut("execution(* com.springDemo.AOPDemo.dao.*.*(..))")
//	private void allMethods() {
//	}
//
//	@Pointcut("execution(* com.springDemo.AOPDemo.dao.*.get*(..))")
//	private void allGetters() {
//	}
//
//	@Pointcut("execution(* com.springDemo.AOPDemo.dao.*.set*(..))")
//	private void allSetters() {
//	}
//
//	@Pointcut("allMethods() && !(allGetters() || allSetters())")
//	private void allMethodsExceptGetterSetter() {
//	}

//	@Before("forDaoPackage()")

//	@Before("allMethodsExceptGetterSetter()")

//	now AOP ordering and making expressions available for other aspects also 

	@Before("com.springDemo.AOPDemo.aspect.AopExpressions.allMethodsExceptGetterSetter()")
//  add join-point for reading parameters
	public void beforeAddAccount(JoinPoint joinPoint) {

		MethodSignature methodSign = (MethodSignature) joinPoint.getSignature();

		System.out.println("MethodSign : " + methodSign);

		Object[] args = joinPoint.getArgs();

		for (var x : args) {
			System.out.println(x);

			if (x instanceof Account) {
				Account a = (Account) x;
				System.out.println("name : " + a.getName());
			}
		}

		System.out.println("==>  Aspect running : Before Add Account !");
	}

}
