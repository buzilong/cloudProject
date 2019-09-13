package com.buzl.springboot.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.buzl.springboot.db.model.Demo;
import com.buzl.springboot.service.DemoService;

/**
 * sample of using spring bean in a util bean
 * 
 * @author buzl
 *
 */
@Component // add this bean to spring IOC
public class IOCBeanTestUtil {

	// the static private bean
	private static DemoService demoService;

	@Autowired
	public void setDemoService(DemoService demoService) {
		IOCBeanTestUtil.demoService = demoService;
	}

	/**
	 * test Demo
	 * 
	 * @param name
	 * @return
	 */
	public static List<Demo> likeName(String name) {
		return demoService.likeName(name);
	}
}
