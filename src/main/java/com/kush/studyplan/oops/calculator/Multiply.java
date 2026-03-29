package com.kush.studyplan.oops.calculator;

import java.util.List;

public class Multiply implements Operation {

	@Override
	public int performOperation(List<Integer> nums) {
		int sum=1;
		for(int num:nums) sum*=num;
		return sum;
	}

}
