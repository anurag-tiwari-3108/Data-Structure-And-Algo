package com.codex.dsa.hashmaps;

public class JavaMapEmployee {

	public static String cName ="org.java.app.Map.Employee :: " ;
	private int id;
	private String name;
	private int salary;
	int count = 1;

	public JavaMapEmployee(int id, String name, int salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
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
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int hashCode() {
		return this.id;

	}

	@Override
	public boolean equals(Object emp){	
		if (this == emp)
				return true;
		if(emp == null && emp .getClass() != this.getClass())
			return false;
		JavaMapEmployee empObj  = (JavaMapEmployee) emp;
		return (empObj.name == this.name && empObj.id == this.id &&  empObj.salary ==  this.salary);
	}
}
