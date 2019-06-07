package com.buzl.springboot.model.request;

import javax.validation.constraints.NotBlank;

public class DemoReqDTO {

	@NotBlank(message="Name is empty")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
