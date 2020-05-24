package com.reflxn.sample;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ExecutorUtil {

	// System.out.print("class name from executor "+className)

	public static Method findMethod(Class classInstances, String methodName) throws NoSuchMethodException {
		if (methodName == null || methodName.trim().equals(""))
			throw new NoSuchMethodException("method name should not be empty or null");

		Method method = null;
		Method[] methods = classInstances.getDeclaredMethods();

		for (int i = 0; i < methods.length && method == null; i++) {
			if (methods[i].getName().equals(methodName)) {
				method = methods[i];

			}

		}
		if (method != null) {
			return method;
		} else
			throw new NoSuchMethodException("No such method " + methodName + " on class " + classInstances.getName());

	}

	@Deprecated
	public static boolean checkParams(Class[] originalParams, Class[] passedParams) {

		// whn i tried not working withh primitive with ref type

		if (originalParams == null && passedParams == null)
			return true;
		if (originalParams == null && passedParams != null)
			return false;
		if (originalParams != null && passedParams == null)
			return false;

		if (originalParams.length != passedParams.length)
			return false;

		/*
		 * if (formalParams.length == 0) return true;
		 */
		int j = 0;

		while (j < originalParams.length && originalParams[j].equals(passedParams[j])) {
			j++;

		}

		if (j != originalParams.length) {
			return false;
		}

		return true;
	}
	@Deprecated
	public static Class[] getParames(Object params[]) {

		if (params == null)
			return null;
		Class[] paramTypes = new Class[params.length];
		for (int i = 0; i < paramTypes.length; i++) {
			paramTypes[i] = params[i].getClass();
		}
		return paramTypes;

	}

	public static Object convert(Class<?> targetType, String text) {
		PropertyEditor editor = PropertyEditorManager.findEditor(targetType);
		editor.setAsText(text);
		return editor.getValue();
	}

}
