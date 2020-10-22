package com.spring_aop.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		//add delay
		try {
			TimeUnit.SECONDS.sleep(5);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "Expect heavy traffic this morning";
	}

	public String getFortune(boolean tripeWire) {
		if(tripeWire) {
			throw new RuntimeException("TripeWire set to true");
		}
		return getFortune();
	}
	
}
