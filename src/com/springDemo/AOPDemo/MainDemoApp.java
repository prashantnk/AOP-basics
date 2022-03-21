package com.springDemo.AOPDemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springDemo.AOPDemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {

//		create application context
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

//		get bean of target object

		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);

//		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
//		call the method

//		accountDAO.addAccount(new Account(), false);
//
//		accountDAO.setName(null);
//		accountDAO.getNumber();
//
//		membershipDAO.addMember();

		var x = accountDAO.findAccounts(false);

		System.out.println("\n In MainAPP : \n");

		System.out.println(x);

//		close context

		context.close();

	}

}
