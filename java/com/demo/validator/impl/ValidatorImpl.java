package com.demo.validator.impl;

import java.util.Iterator;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Path.Node;
import javax.validation.Path.ParameterNode;
import javax.validation.Path.PropertyNode;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.demo.validator.models.Car;

public class ValidatorImpl {

	private static Validator validator;

	public static void main(String[] args) {
		try {

			ValidatorFactory validatorFactory = Validation
					.buildDefaultValidatorFactory();
			validator = validatorFactory.getValidator();

			Car c = new Car();
			c.setManufacturer("ho@");

			Set<ConstraintViolation<Car>> validationIssues = validator
					.validate(c);

			for (Iterator<ConstraintViolation<Car>> iter = validationIssues
					.iterator(); iter.hasNext();) {
				ConstraintViolation<Car> voilation = iter.next();
				print(voilation.getMessage());
				Iterator<Node> it = voilation.getPropertyPath().iterator();
				PropertyNode nde = it.next().as(PropertyNode.class);
				print(voilation.getPropertyPath().toString());
				print(nde.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void print(String s) {
		System.out.println(s);
	}
}
