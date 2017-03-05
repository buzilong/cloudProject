package com.buzl.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buzl.springboot.bean.db.Demo;
import com.buzl.springboot.service.DemoService;

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
