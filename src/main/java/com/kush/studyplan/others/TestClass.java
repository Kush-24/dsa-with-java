package com.kush.studyplan.others;

public class TestClass {
	private int y = 1111;
	private static int x = 1111;
	static {
		x = x-- - --x;
	}
	{
		x = x++ + ++x;
		y = y++ + ++y;
	}

	public static void main(String[] args) {
		TestClass obj = new TestClass();
		System.out.println(obj.x + " " + obj.y);
	}
}
