package com.Weconnet.REST;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@ComponentScan()
@RestController

public class RestApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestApplication.class, args);
	}
	@RequestMapping("/")
	public ModelAndView home()
	{
		System.out.println("HOME PAGE ENVOKED to check out the documentation");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
}
