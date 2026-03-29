package com.kush.java.threads;
import java.util.concurrent.atomic.AtomicInteger;

class SharedResource {
    // Example 1: Using volatile keyword
    private volatile int volatileCounter = 0;

    // Example 2: Using AtomicInteger for atomic operations
    private AtomicInteger atomicCounter = new AtomicInteger(0);

    public int getVolatileCounter() {
        return volatileCounter;
    }

    public int getAtomicCounter() {
        return atomicCounter.get();
    }

    // Example 1: Incrementing the volatile counter
    public void incrementVolatileCounter() {
        volatileCounter++;
    }

    // Example 2: Incrementing the atomic counter
    public void incrementAtomicCounter() {
        atomicCounter.incrementAndGet();
    }
}

public class VolatileAtomicExample {
    public static void main(String[] args) throws InterruptedException {
        final SharedResource sharedResource = new SharedResource();

        // Example 1: Using volatile keyword
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    sharedResource.incrementVolatileCounter();
                }
            }).start();
        }

        // Example 2: Using AtomicInteger
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    sharedResource.incrementAtomicCounter();
                }
            }).start();
        }

        // Wait for all threads to complete
        Thread.sleep(2000);

        // Output final counts
        System.out.println("Volatile Counter: " + sharedResource.getVolatileCounter());
        System.out.println("Atomic Counter: " + sharedResource.getAtomicCounter());
    }
	/*
	 * Volatile Counter: 4459 Atomic Counter: 5000 
	 * 
	 * The output you provided confirms the expected behavior based on the usage of
	 * `volatile` and `AtomicInteger`. - `Volatile Counter: 4459`:
	 * 
	 *  The `volatile`counter is not atomic, and multiple threads are concurrently incrementing it.
	 * Due to the lack of atomicity, some increments may be lost, resulting in a
	 * count lower than the expected 5000. - 
	 * 
	 * `Atomic Counter: 5000`: The`AtomicInteger` counter, on the other hand, uses atomic operations provided
	 * by the `AtomicInteger` class. This ensures that increments are performed
	 * atomically, without interference from other threads, leading to the expected
	 * count of 5000. This example demonstrates how `volatile` ensures visibility
	 * across threads but does not provide atomicity, whereas `AtomicInteger`
	 * guarantees atomic operations, preventing race conditions.
	 */
}
