package com.springDemo.AOPDemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addMember() {
		System.out.println(getClass() + " Adding new member !");
	}

}
