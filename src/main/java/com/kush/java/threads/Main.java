package com.kush.java.threads;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class SynchronizationExample {
    
    // Example 1: Synchronized Method
    public synchronized void synchronizedMethod() {
        System.out.println("Start synchronizedMethod");
        // Critical section
        System.out.println("End synchronizedMethod");
    }

    // Example 2: Synchronized Block
    public void synchronizedBlock() {
        System.out.println("Start synchronizedBlock");
        // Non-critical section

        // Synchronized block
        synchronized (this) {
            // Critical section
            System.out.println("Inside synchronizedBlock");
        }

        // Non-critical section
        System.out.println("End synchronizedBlock");
    }

    // Example 3: ReentrantLock
    private final Lock lock = new ReentrantLock();

    public void reentrantLockExample() {
        System.out.println("Start reentrantLockExample");
        // Non-critical section

        lock.lock(); // Acquire the lock
        try {
            // Critical section
            System.out.println("Inside reentrantLockExample");
        } finally {
            lock.unlock(); // Release the lock in a finally block
        }

        // Non-critical section
        System.out.println("End reentrantLockExample");
    }
}

public class Main {
    public static void main(String[] args) {
        SynchronizationExample example = new SynchronizationExample();

        // Example 1: Synchronized Method
        new Thread(() -> example.synchronizedMethod()).start();

        // Example 2: Synchronized Block
        new Thread(() -> example.synchronizedBlock()).start();

        // Example 3: ReentrantLock
        new Thread(() -> example.reentrantLockExample()).start();
    }
}
