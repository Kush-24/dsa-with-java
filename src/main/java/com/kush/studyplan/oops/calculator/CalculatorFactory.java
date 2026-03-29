package com.kush.studyplan.oops.calculator;

public class CalculatorFactory {
	public static Operation getOperationType(String ope) {
		if("Addition".equalsIgnoreCase(ope))
			return new Addition();
		else if ("Subtraction".equalsIgnoreCase(ope))
			return new Subtraction();
		else if ("Multiply".equals(ope))
			return new Multiply();
		else 
			return new Division();
	}
}
