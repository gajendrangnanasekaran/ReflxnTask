package com.reflxn.sample;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Scanner;

public class TaskMain {
	public static void main(String args[]) throws InstantiationException, IllegalAccessException, InvocationTargetException {

		
		  Executor exe = new Executor();
		  
		  System.out.println("passed Inputs  :"+Arrays.toString(args));
		  
		  
		  String className=args[0];
		  System.out.println("passed class  :"+className);

		  String methodName=args[1];
		  System.out.println("passed method  :"+methodName);

		  String[] passedArgs = Arrays.copyOfRange(args, 2, args.length);

		  System.out.println("passed parameters  :"+Arrays.toString(passedArgs));

		
		  exe.executeTask(className, methodName,passedArgs);
	
	}
}
