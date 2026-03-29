package com.kush.studyplan.oops.calculator;

import java.util.List;

public class Subtraction implements Operation {

	@Override
	public int performOperation(List<Integer> nums) {
		if(nums.size() == 2) {
		int num1=nums.get(0);
		int num2=nums.get(1);
		return num1 - num2;
		}
		return 0;
	}

}
