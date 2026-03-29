package com.kush.java.threads;

public class ByRunnable {
public static void main(String[] args) {
	Thread2 t2=new Thread2();
	  new Thread(t2).start();
	
	Runnable t3=new Runnable() {
		@Override
		public void run() {
			System.out.println("new thread...");
		}
	};
	System.out.println("before starting thread...");
	Thread t4=new Thread(t3);// Using the constructor Thread(Runnable r)  
	t4.start();
}
}

class Thread2 implements Runnable{
	@Override
	public void run() {
		System.out.println("--- "+Thread.currentThread());
	}
	
}
