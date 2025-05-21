package com.codex.dsa.greedyalgorithms;

public class Employee {

	public int id;
	public String name;
	public float salary;

	public Employee(float salary, String name) {
		this.salary = salary;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return id;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {		
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		
		return super.equals(obj);
	}
	@Override
	public String toString() {		
		return this.salary +"  " +this.name;
	}
	

	public  void incrementSalary(int empid) {	
		
		
		synchronized (name) {
			
		}
		
		
	}
	
	
}
