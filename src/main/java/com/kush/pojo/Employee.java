package com.kush.pojo;

public class Employee {
	private int employeeNumber;
	private String name;
	private String department;
	private long salary;
	private int age;
	private Gender gender;
	
	public Employee(String name,long salary) {
		this.name=name;
		this.salary=salary;
	}

	public int getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(int employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [employeeNumber=");
		builder.append(employeeNumber);
		builder.append(", name=");
		builder.append(name);
		builder.append(", department=");
		builder.append(department);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", age=");
		builder.append(age);
		builder.append(", gender=");
		builder.append(gender);
		builder.append("]");
		return builder.toString();
	}
}
