package com.demo.validator.impl;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Path.ConstructorNode;
import javax.validation.Path.PropertyNode;
import javax.validation.executable.ExecutableValidator;

import com.demo.validator.models.Customs;

//for methods and constructors
public class ExecutorValidatorImpl {

	
	private static ExecutableValidator validator;
	
	public static void main(String[] args) {
		try {
			
			ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
			validator = validatorFactory.getValidator().forExecutables();
			Customs custom = new Customs();
			Constructor constructor = Customs.class.getConstructor();
			Set<ConstraintViolation<Customs>> constructorRet = validator.validateConstructorReturnValue(constructor, custom);
			System.out.println(constructorRet);
			for(Iterator<ConstraintViolation<Customs>> iter = constructorRet.iterator();iter.hasNext();){
				ConstraintViolation<Customs> voilation = iter.next();
				System.out.println(voilation.getPropertyPath());
				ConstructorNode node = voilation.getPropertyPath().iterator().next().as(ConstructorNode.class);
				System.out.println(node.getName());
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
