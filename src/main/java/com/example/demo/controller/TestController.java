package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class TestController {//http://localhost:8080/getTest
	
	@GetMapping("/getTest")
	public ModelAndView getTest() {
		ModelAndView mv= new ModelAndView();
		
		mv.addObject("msg", "Hi All welcome in velocity");//name and value
		
		mv.setViewName("index");
		return mv;
		
		
		
	}
	
	@GetMapping("/getTest1")
	public ModelAndView getTest1() {
		ModelAndView mv= new ModelAndView();
		
		mv.addObject("msg", "Hi Student How are you");//name and value
		
		mv.setViewName("index");
		return mv;
		
		
		
	}
	
	

}
