package com.kush.studyplan.oops.calculator;

import java.util.List;

public class Addition implements Operation{

	@Override
	public int performOperation(List<Integer> nums) {
		System.out.println("Doing addition..");
		int sum=0;
		for(int num:nums) sum+=num;
		return sum;
	}

}
