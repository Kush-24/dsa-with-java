package com.kush.studyplan.oops.calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {
  public static void main(String[] args) {
	List<Integer> numbers=Arrays.asList(2,5,43);
	Operation ope=CalculatorFactory.getOperationType("Multiply");
	int addition=ope.performOperation(numbers);
	System.out.println("Addition of numbers "+numbers+" is :"+addition);
	
}
}
