package com.reflxn.sample;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Executor {

	public void executeTask(String className, String methodname, String passedArgs[])
			throws InstantiationException, IllegalAccessException, InvocationTargetException {
		Class actualParamTypes[] = null;
		try {

			// System.out.print("class name from executor "+className);

			Class cls = Class.forName(className);
			Object obj = cls.newInstance();
			Method method = ExecutorUtil.findMethod(cls, methodname);

			if (!(method.getParameterCount() == passedArgs.length)) {
				throw new IllegalArgumentException();
			}

			actualParamTypes = method.getParameterTypes();
			System.out.println("actualParamTypes ::" + Arrays.toString(actualParamTypes));

			Object convertedArgs[] = new Object[actualParamTypes.length];

			for (int i = 0; i < method.getParameterCount(); i++) {

				convertedArgs[i] = ExecutorUtil.convert(actualParamTypes[i], passedArgs[i]);

			}

			System.out.println("convertedArgs :: " + Arrays.toString(convertedArgs));

			method.invoke(obj, convertedArgs);

		} catch (ClassNotFoundException e) {
			System.out.println("invalid  class  : " + className);

		} catch (NoSuchMethodException e) {
			System.out.println("invalid method   :" + methodname + ": for this class : " + className);
		} catch (IllegalArgumentException e) {
			System.out.println("invalid arguments : " + Arrays.toString(passedArgs));
		} /*
			 * catch (InvocationTargetException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */

	}

}
