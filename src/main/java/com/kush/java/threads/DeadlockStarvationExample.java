package com.kush.java.threads;

/*
 * Deadlock occurs when two or more threads are blocked indefinitely, each waiting for the other. 
 * Starvation is when a thread is unable to gain regular access to shared resources. 
 * Both situations require careful design and synchronization to be avoided.
 */
public class DeadlockStarvationExample {

	// Shared resources
	static class SharedResource {
		synchronized void resource1(SharedResource other) {
			System.out.println(Thread.currentThread().getName() + " is executing resource1()");
			try {
				Thread.sleep(100); // Simulating some work
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " is trying to call resource2()");
			other.resource2(this);
		}

		synchronized void resource2(SharedResource other) {
			System.out.println(Thread.currentThread().getName() + " is executing resource2()");
			try {
				Thread.sleep(100); // Simulating some work
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + " is trying to call resource1()");
			other.resource1(this);
		}
	}

	public static void main(String[] args) {
		SharedResource resource1 = new SharedResource();
		SharedResource resource2 = new SharedResource();

		// Thread 1
		new Thread(() -> resource1.resource1(resource2), "Thread-1").start();

		// Thread 2
		new Thread(() -> resource2.resource2(resource1), "Thread-2").start();

		// Simulating starvation by creating a long-running thread
		new Thread(() -> {
			while (true) {
				System.out.println("Starvation thread is running...");
			}
		}, "Starvation-Thread").start();
	}
}
