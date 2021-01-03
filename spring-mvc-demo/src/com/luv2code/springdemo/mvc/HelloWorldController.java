package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormTwo")
	public String letsShout(HttpServletRequest request, Model model) {
		
		String name = request.getParameter("studentName");
		model.addAttribute("message", "YO! " + name.toUpperCase());
		return "helloworld";
	}
	
	@RequestMapping("/processFormThree")
	public String processFormThree(@RequestParam("studentName") String name, Model model) {
		
		model.addAttribute("message", "MEOW :)  " + name.toUpperCase());
		return "helloworld";
	}
}
