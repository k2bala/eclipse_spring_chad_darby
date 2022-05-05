package com.luv2code.springboot.thymeleafdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springboot.thymeleafdemo.entity.Employee;
import com.luv2code.springboot.thymeleafdemo.service.EmployeeService;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public String listEmployees(Model model) {
		model.addAttribute("employees", employeeService.findAll());

		return "employees/list-employees";
	}

	@GetMapping("/employees/showFormForAdd")
	public String showFormForAdd(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		return "employees/employee-form";
	}
	
	@GetMapping("/employees/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
		//Get employee
		Employee employee = employeeService.findById(id);
		//Populate attribute with employe
		model.addAttribute("employee", employee);

		return "employees/employee-form";
	}
	
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		//save employee
		employeeService.save(employee);
		//use redirect to prevent duplicate submissions
		return "redirect:/employees";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("employeeId") int theId) {
		
		// delete the employee
		employeeService.deleteById(theId);
		
		// redirect to /employees/list
		return "redirect:/employees/list";
		
	}
	
	@GetMapping("/search")
	public String delete(@RequestParam("employeeName") String theName,
						 Model theModel) {
		
		// delete the employee
		List<Employee> theEmployees = employeeService.searchBy(theName);
		
		// add to the spring model
		theModel.addAttribute("employees", theEmployees);
		
		// send to /employees/list
		return "/employees/list-employees";
		
	}

}
