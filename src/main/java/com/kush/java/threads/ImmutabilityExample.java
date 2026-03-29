package com.kush.java.threads;

/*ImmutablePerson is a class with final fields and no setters, making it immutable.
Multiple threads can safely access the immutable person object without the need for synchronization 
because the object's state cannot be modified after creation.
*/

final class ImmutablePerson {
    private final String name;
    private final int age;

    public ImmutablePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class ImmutabilityExample {
    public static void main(String[] args) {
        ImmutablePerson person = new ImmutablePerson("John", 25);

        // Creating multiple threads to access the immutable person object
        for (int i = 0; i < 5; i++) {
            new Thread(() -> {
                // Accessing the immutable person object
                System.out.println(Thread.currentThread().getName() +
                        ": Name - " + person.getName() + ", Age - " + person.getAge());
            }).start();
        }
    }
}
