package com.codex.dsa.hashmaps;

import java.util.*;
public class JavaMapEmployeeDemo {

	public static String cName = "org.java.app.Map.JavaMapEmployeeDemo :: ";
	public static void main(String [] args){
		Map<JavaMapEmployee, String> aMap  = new HashMap<JavaMapEmployee, String>();
		JavaMapEmployee emp1 = new JavaMapEmployee(101001, "Anurag", 10000000);
		JavaMapEmployee emp2 = new JavaMapEmployee(101002, "Anurag", 10000000);
		JavaMapEmployee emp3 = new JavaMapEmployee(101003, "Anurag", 10000000);
		JavaMapEmployee emp4 = new JavaMapEmployee(101004, "Anurag", 10000000);
		JavaMapEmployee emp5 = new JavaMapEmployee(101005, "Anurag", 10000000);

		System.out.println(cName+"Created 5 Emp Objects");
		try {
		aMap.put(emp1, "Working in BFSI emp1");
		Thread.sleep(1000);		
		aMap.put(emp2, "Working in BFSI emp2");
		Thread.sleep(1000);		
		aMap.put(emp3, "Working in BFSI emp3");
		Thread.sleep(1000);		
		aMap.put(emp4, "Working in BFSI emp4");
		Thread.sleep(1000);		
		aMap.put(emp5, "Working in BFSI emp5");
		Thread.sleep(1000);
		
		System.out.println(cName+"JavaMapEmployee Data insertion into map is completed");

		Thread.sleep(1000);
		System.out.println(aMap.get(emp1));
		Thread.sleep(1000);
		System.out.println(aMap.get(emp2));
		Thread.sleep(1000);
		System.out.println(aMap.get(emp3));
		Thread.sleep(1000);
		System.out.println(aMap.get(emp4));
		Thread.sleep(1000);
		System.out.println(aMap.get(emp5));
		Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	
		
		
	}
}
