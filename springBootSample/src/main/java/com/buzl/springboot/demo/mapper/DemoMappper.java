package com.buzl.springboot.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.buzl.springboot.demo.bean.Demo;

public interface DemoMappper {
	
	@Select("select * from demo where name like '%'||#{name}||'%' ")
	public List<Demo> likeName(String name);

	@Select("select * from demo where id = #{id}")
	public Demo getById(long id);

	@Select("select name from demo where id = #{id}")

	public String getNameById(long id);
}
