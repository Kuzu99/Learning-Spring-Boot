package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@RequestMapping("/")
	public String index() {
		// call hello.html
		return "hello";
	}
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(defaultValue = "Hi!") String message, Model model) {
		model.addAttribute("sample", message);
		return "hello";
	}
	
	@GetMapping("/form")
	public String form() {
		return "form";
	}
	
	@PostMapping("/confirm")
	public String confirm(@RequestParam String message, Model model) {
		model.addAttribute("message", message);
		return "confirm";
	}
}
