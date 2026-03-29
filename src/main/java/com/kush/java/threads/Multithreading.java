package com.kush.java.threads;


//1> By extending the thread class
public class Multithreading{
	public static void main(String[] args) {
		System.out.println("print value");
		Thread1 t1=new Thread1();
		t1.start();
	}
}

class Thread1 extends Thread{
	@Override 
	public void run() {
		for(int i=0;i<5;i++) {
			System.out.println("current thread is running" + Thread.currentThread());
		}
	}
}


