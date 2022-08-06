package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Inquiry;
import com.example.demo.model.User;

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
	public String readForm(@ModelAttribute User user) {
		return "form";
	}
	
	@PostMapping("/form")
	public String confirm(@ModelAttribute User user) {
		return "confirm";
	}
	
	@GetMapping("/inquiry")
	public String inquiry(@ModelAttribute Inquiry inquiry) {
		return "inquiry";
	}
	
	@PostMapping("/inquiry")
	public String inquiryConfirm(@Validated @ModelAttribute Inquiry inquiry, BindingResult result) {
		if (result.hasErrors()) {
			return "inquiry";
		}
		return "inquiryconfirm";
	}
}
