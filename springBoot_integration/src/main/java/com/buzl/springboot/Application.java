package com.buzl.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = { "config/application.properties" })
@MapperScan("com.buzl.springboot.mapper*")
public class Application{
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}
