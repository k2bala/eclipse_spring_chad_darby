package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	List<Student> students;
	
	@PostConstruct() 
	public void loadData() {
		students = new ArrayList<>();
		students.add(new Student("Aa","Bb"));
		students.add(new Student("Cc","Dd"));
		students.add(new Student("Ee","Ff"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		if (studentId < 0 || studentId >= students.size() ) {
			throw new StudentNotFoundException(" No student found for id " + studentId);
		}
		return students.get(studentId);
	}
	
}
