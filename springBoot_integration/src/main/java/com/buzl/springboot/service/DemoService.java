package com.buzl.springboot.service;

import com.buzl.springboot.db.model.Demo;
import com.buzl.springboot.mapper.DemoMappper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author buzl
 */
@Service
public class DemoService {

	@Resource
	private DemoMappper demoMappper;

	public List<Demo> likeName(String name) {
		return demoMappper.likeName(name);
	}
}
