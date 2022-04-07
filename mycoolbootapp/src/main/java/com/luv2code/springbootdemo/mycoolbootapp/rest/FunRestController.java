package com.luv2code.springbootdemo.mycoolbootapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	@GetMapping("/")
	public String sayHello () {
		return "Hello: Time is " + LocalDateTime.now();
	}

}
