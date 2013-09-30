package com.demo.validator.models;

import java.util.concurrent.Callable;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class Customs {

	@Min(10)
	private int xy;
	
	@Length(max=4,min=2)
	private String name;
	
	@NotNull
	private String hola;
	
	public void checkFor(@Max(100) int integer){
		System.out.println(integer);
	}
	
	
	public @NotNull Object get(Callable<Object> callable) throws Exception{
		return callable.call();
	}
	
	@Valid
	public Customs(){
		this.xy = 5;
		this.hola = "hello";
		this.name = "customes";
	}
	
	public Customs(@Max(5) int xy, @NotNull String name, @Length(max=5,min=2) String hola){
		this.xy = xy;
		this.hola = hola;
		this.name = name;
	}
	
}
