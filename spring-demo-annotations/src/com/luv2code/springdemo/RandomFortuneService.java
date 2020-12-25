package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService {
	
	private String[] data = {
			"Random Fortune 1",
			"Random Fortune 2",
			"Random Fortune 3"
	};
	
	private Random random = new Random();

	@Override
	public String getFortune() {
		int index = random.nextInt(data.length);
		return data[index]; 
	}

}
