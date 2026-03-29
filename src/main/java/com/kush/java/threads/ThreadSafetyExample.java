package com.kush.java.threads;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ThreadSafeList {
    // Using synchronizedList to achieve thread safety
    public List<String> synchronizedList = Collections.synchronizedList(new ArrayList<>());

    public void addElement(String element) {
        synchronized (synchronizedList) {
            synchronizedList.add(element);
        }
    }

    public String getElement(int index) {
        synchronized (synchronizedList) {
            return synchronizedList.get(index);
        }
    }
}

public class ThreadSafetyExample {
    public static void main(String[] args) {
        final ThreadSafeList threadSafeList = new ThreadSafeList();

        // Creating multiple threads to access the shared list
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                for (int j = 0; j < 3; j++) {
                    threadSafeList.addElement(Thread.currentThread().getName() + "-" + j);
                }
            }).start();
        }

        // Creating another thread to read from the list
        new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                System.out.println("Element at index " + i + ": " + threadSafeList.getElement(i));
            }
        }).start();
        
        System.out.println(threadSafeList.synchronizedList);
    }
}
