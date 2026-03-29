package com.kush.studyplan.others;

public class Threads {
	public static void main(String[] args) {
		Thread1 t1 = new Thread1();
		t1.start();
		System.out.println("Main class thread");
		Thread2 t2 = new Thread2();
		t2.start();
	}
}

class Thread1 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++)
			if (i % 2 == 1)
				System.out.println("odd");

	}
}

class Thread2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			if (i % 2 == 0)
				System.out.println("even");
		}

	}
}
