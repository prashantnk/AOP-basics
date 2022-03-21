package com.springDemo.AOPDemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.springDemo.AOPDemo.Account;

@Aspect
@Component
@Order(-1)
public class AfterReturningLoggingAspect {

	@After("execution(* com.springDemo.AOPDemo.dao.AccountDAO.findAccounts(..))")
	public void findAccountAfterFinally(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("\n @After (finally) in the method : " + methodName);
	}

	@AfterThrowing(pointcut = "execution(* com.springDemo.AOPDemo.dao.AccountDAO.findAccounts(..))", throwing = "exception")
	public void findAccountAfterThrowing(JoinPoint joinPoint, Throwable exception) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("\n @AfterThrowing in the method : " + methodName);

		System.out.println("exception in @afterThrowing : " + exception);
	}

	@AfterReturning(pointcut = "execution(* com.springDemo.AOPDemo.dao.AccountDAO.findAccounts(..))", returning = "theData")
	public void findAccountAfterReturning(JoinPoint joinPoint, List<Account> theData) {
		String methodName = joinPoint.getSignature().toShortString();
		System.out.println("\n After Returning in the method : " + methodName);

		System.out.println("Data before modification : " + theData);

		AccountToUpperCase(theData);

		System.out.println("\nData After modification : " + theData);

	}

	private void AccountToUpperCase(List<Account> theData) {
		for (var acc : theData) {
			acc.setName(acc.getName().toUpperCase());
		}
	}

}
