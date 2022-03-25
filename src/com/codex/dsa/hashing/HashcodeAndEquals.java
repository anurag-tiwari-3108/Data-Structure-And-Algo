package com.codex.dsa.hashing;

public class HashcodeAndEquals {
	Employee emp_1 = new Employee(1, "Emp-1");
	Employee emp_2 = new Employee(2, "Emp-2");
	Employee emp_3 = new Employee(3, "Emp-3");
	Employee emp_4 = new Employee(4, "Emp-4");
}

class Employee {
	int empId;
	String name;

	public Employee(int empid, String name) {
		this.empId = empid;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return super.hashCode() * this.empId;
	}

	@Override
	public boolean equals(Object obj) {

		return super.equals(obj);
	}
}