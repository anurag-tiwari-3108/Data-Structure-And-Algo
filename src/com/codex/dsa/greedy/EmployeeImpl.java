package com.codex.dsa.greedy;

import java.util.HashMap;

public class EmployeeImpl {

	public static void main(String[] args) {
		Employee emp1 = new Employee(101.1f, "Anurag");
		Employee emp2 = new Employee(101.2f, "Tom");
		Employee emp3 = new Employee(101.3f, "David");
		Employee emp4 = new Employee(101.4f, "Jack");

		HashMap<String, Employee> map = new HashMap<String, Employee>();

		map.put(emp1.name, emp1);
		map.put(emp2.name, emp2);
		map.put(emp3.name, emp3);
		map.put(emp4.name, emp4);

		System.out.println(map.get("Tom"));
	}
}
