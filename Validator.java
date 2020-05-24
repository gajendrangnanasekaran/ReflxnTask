package com.reflxn.sample;

import java.util.ArrayList;
import java.util.List;

public class Validator {

	public boolean classChk(String className) {

		boolean result = false;
		List<String> classes = new ArrayList<>();
		classes.add("Calculater");
		classes.add("HelloWorld");

		if ("".equals(className) || className == null) {
			// throw new RuntimeException("class name should not be null or empty");

			result = false;
		} else if (!classes.contains(className)) {
			// throw new RuntimeException("class name should be Calculator or helloWorld");
			result = false;
		}

		if (classes.contains(className))
			result = true;

		return result;

	}

	public boolean methodchk(String className, String methodName) {

		boolean result = false;
		List<String> methods = new ArrayList<>();
		methods.add("add");
		methods.add("hello");

		if ("".equals(methodName) || methodName == null) {
			throw new RuntimeException("methodName name should not be null or empty");
		} else if (!methods.contains(className)) {
			throw new RuntimeException("methodName name should be Calculator or helloWorld");

		}

		if (methods.contains(methodName))
			result = true;

		return result;

	}
}
