package com.kush.java.java8;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

import com.kush.pojo.Employee;

public class StreamsImp {
	public static void main(String[] args) {
//Question: Given a list of employees, find the average salary and 
// print the names of employees whose salary is above the average.
		List<Employee> emps = Arrays.asList(new Employee("emp1", 2000), new Employee("emp2", 5000),
				new Employee("emp3", 8000), new Employee("emp4", 12000), new Employee("emp5", 1200));
		OptionalDouble avg = emps.stream().mapToLong(Employee::getSalary).average();
		avg.ifPresent(val -> System.out.println(val));
		 List<Employee> aaEmp = emps.stream()
                 .filter(employee -> employee.getSalary() > avg.getAsDouble()).toList();
		 
	}
}
