package com.example.demo.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/*
 * Created by Haryo Parigroho
 */
@Controller
public class PageController
{
	@RequestMapping("/hello")
	public String index ()
	{
		return "hello";
	}
	
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "dunia")String name, Model model)
	{
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@RequestMapping(value ={"/greeting/", "/greeting/{name}"})
	public String greetingPath(@PathVariable Optional<String> name, Model model) 
	{
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		}
		else {
			model.addAttribute("name", "dengklek");
		}
		return "greeting";
	}
	
	@RequestMapping("/perkalian")
	public String multiplication(@RequestParam(value = "a", required = false)Integer a, 
			@RequestParam(value = "b", required = false)Integer b, Model model)
	{
		if(a == null) {
			a = 0;
		}
		model.addAttribute("a", a);
		
		if(b == null) {
			b = 0;
		}
		model.addAttribute("b", b);
		
		model.addAttribute("result", a * b);
		
		return "perkalian";
	}
}

