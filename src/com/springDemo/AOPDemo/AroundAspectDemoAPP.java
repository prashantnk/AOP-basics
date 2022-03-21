package com.springDemo.AOPDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springDemo.AOPDemo.services.TrafficService;

public class AroundAspectDemoAPP {

	public static void main(String[] args) {

//		create application context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

//		get bean of target object

		TrafficService ts = context.getBean("trafficService", TrafficService.class);

		System.out.println("\n In MainAPP : Calling getFortune \n");

		boolean makeException = true;

		Object x = null;
		try {
			x = ts.getFortune(makeException);
		} catch (Exception e) {
			System.out.println("In main app : " + e.getMessage());
		}

		System.out.println("\n In MainAPP : Fortune is : \n");

		System.out.println(x);
//		close context

		context.close();

	}

}
