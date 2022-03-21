package com.springDemo.AOPDemo.services;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficService {

	public String getFortune() {
//		simulate time delay

		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return "Today , you won't get into traffic !";
	}

	public Object getFortune(boolean makeException) {
		if (makeException) {
			throw new RuntimeException("Traffic Exception Occurred !");
		}
		return getFortune();
	}

}
