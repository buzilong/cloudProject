package com.buzl.springboot.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buzl.springboot.demo.bean.Demo;
import com.buzl.springboot.demo.mapper.DemoMappper;

@Service
public class DemoService {
	@Autowired
	private DemoMappper demoMappper;

	public List<Demo> likeName(String name) {
		return demoMappper.likeName(name);
	}
}
