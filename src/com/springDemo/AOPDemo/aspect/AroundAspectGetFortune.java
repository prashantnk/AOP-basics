package com.springDemo.AOPDemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-2)
public class AroundAspectGetFortune {

	private Logger myLogger = Logger.getLogger(AroundAspectGetFortune.class.getClass().getName());

	@Around("execution(* com.springDemo.AOPDemo.services.TrafficService.getFortune(..))")
	public Object getFortuneAroundAspect(ProceedingJoinPoint PJP) throws Throwable {
		String methodName = PJP.getSignature().toShortString();

		myLogger.info("\n In @Around : " + methodName);

		long begin = System.currentTimeMillis();

		Object result = null;
		try {
			result = PJP.proceed();
		} catch (Throwable e) {
			myLogger.warning(e.getMessage());
//			result = "Exception occurred , try again !";
			throw e;
		}

		long end = System.currentTimeMillis();

		myLogger.info("\n in @Around : result : " + result);
		myLogger.info("\n in @Around : Duration : " + (end - begin) / 1000 + " Seconds ");
		return result;

	}

}
