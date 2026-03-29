package com.kush.studyplan.lld.ratelimiter;
public class RateLimiterTest {
    public static void main(String[] args) {
    	System.out.println("Starting...");
        RateLimiter rateLimiter = new RateLimiter(5, 10000); // Allowing 5 requests in 10 seconds

        // Simulating requests
        String clientId = "client1";

        // Test allowing 5 requests within the time window
        for (int i = 0; i < 5; i++) {
            if (rateLimiter.allowRequest(clientId)) {
                System.out.println("Request allowed for " + clientId);
            } else {
                System.out.println("Request limit exceeded for " + clientId);
            }
        }

        // Wait for the time window to expire
        try {
            Thread.sleep(11000); // Wait for 11 seconds (more than the time window)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Test allowing additional requests after the time window has passed
        for (int i = 0; i < 3; i++) {
            if (rateLimiter.allowRequest(clientId)) {
                System.out.println("Request allowed for " + clientId);
            } else {
                System.out.println("Request limit exceeded for " + clientId);
            }
        }
    }
}
