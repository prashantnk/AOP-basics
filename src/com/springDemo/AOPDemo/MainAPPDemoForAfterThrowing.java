package com.springDemo.AOPDemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springDemo.AOPDemo.dao.AccountDAO;

public class MainAPPDemoForAfterThrowing {

	public static void main(String[] args) {

//		create application context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

//		get bean of target object

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

		List<Account> acc = null;

		try {
			acc = accountDAO.findAccounts(false);
		} catch (Exception e) {
			System.out.println("In main APP : " + e);
		}

		System.out.println("\n In MainAPP : \n");

		System.out.println(acc);

//		close context

		context.close();

	}

}
