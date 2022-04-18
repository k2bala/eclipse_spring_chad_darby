package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.luv2code.springboot.thymeleafdemo.model.Employee;

@Controller
public class EmployeeController {
	
	private List<Employee> employees;
	
	@PostConstruct
	private void loadData() {
		Employee emp1 = new Employee(1, "A","B","C");
		Employee emp2 = new Employee(2, "D","E","F");
		Employee emp3 = new Employee(3, "G","H","I");
		
		employees = new ArrayList<>();
		
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
	}
	
	@GetMapping("/employees")
	public String listEmployees(Model model) {
		model.addAttribute("employees", employees);
		
		return "list-employees";
	}

}
