package com.buzl.springboot.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buzl.springboot.bean.db.Demo;
import com.buzl.springboot.service.DemoService;

@RestController
public class DemoController {
	private static final Logger LOGGER = Logger.getLogger(DemoController.class);
	@Autowired
	private DemoService demoService;

	@RequestMapping("/likeName")
	public List<Demo> likeName(String name) {
		LOGGER.info("Enter in controller");
		return demoService.likeName(name);
	}
}
