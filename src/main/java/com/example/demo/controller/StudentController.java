package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Student;

@Controller
public class StudentController {
	
	@GetMapping("/student")
	public String showForm() {//http://localhost:8080/student
		return "student";
	}

	@PostMapping("/register")
	public String registerStudent(Student student, Model model) {
		
		System.out.println(student);
		model.addAttribute("student", student);
		return"sucess";
	}
	
	
}
