package com.springDemo.AOPDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {
	@Pointcut("execution(* com.springDemo.AOPDemo.dao.*.*(..))")
	public void allMethods() {
	}

	@Pointcut("execution(* com.springDemo.AOPDemo.dao.*.get*(..))")
	public void allGetters() {
	}

	@Pointcut("execution(* com.springDemo.AOPDemo.dao.*.set*(..))")
	public void allSetters() {
	}

	@Pointcut("allMethods() && !(allGetters() || allSetters())")
	public void allMethodsExceptGetterSetter() {
	}
}
