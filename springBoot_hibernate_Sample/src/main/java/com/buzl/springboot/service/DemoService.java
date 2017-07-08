package com.buzl.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buzl.springboot.bean.db.Demo;
import com.buzl.springboot.dao.DemoDao;

@Service
public class DemoService {
	@Autowired
	private DemoDao demoDaor;

	public List<Demo> likeName(String name) {
		return demoDaor.findByName(name);
	}
}
