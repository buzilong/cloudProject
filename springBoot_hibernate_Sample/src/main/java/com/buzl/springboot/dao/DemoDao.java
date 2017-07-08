package com.buzl.springboot.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buzl.springboot.bean.db.Demo;

public interface DemoDao extends JpaRepository<Demo, Long>{
	
	public List<Demo> findByName(String name);

}
