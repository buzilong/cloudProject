package com.buzl.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buzl.springboot.demo.bean.Demo;
import com.buzl.springboot.demo.service.DemoService;

@RestController
public class DemoController {
	@Autowired
	private DemoService demoService;

	@RequestMapping("/likeName")
	public List<Demo> likeName(String name) {
		System.out.println("Enter In Controller");
		return demoService.likeName(name);
	}
}
