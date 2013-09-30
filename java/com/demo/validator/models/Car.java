package com.demo.validator.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

public class Car {

	@NotNull
	private String name;
	
	@Max(1)
	private String manufacturer;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	
	
}
