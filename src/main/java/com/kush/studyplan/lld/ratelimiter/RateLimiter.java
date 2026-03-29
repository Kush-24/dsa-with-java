package com.kush.studyplan.lld.ratelimiter;
import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
    private final Map<String, Long> requestTimestamps;
    private final int requestLimit;
    private final long timeWindowInMillis;

    public RateLimiter(int requestLimit, long timeWindowInMillis) {
        this.requestTimestamps = new HashMap<>();
        this.requestLimit = requestLimit;
        this.timeWindowInMillis = timeWindowInMillis;
    }

    /**
     * Checks if the request from a client with a given ID is allowed based on the rate limit.
     *
     * @param clientId The ID of the client making the request.
     * @return true if the request is allowed within the rate limit, false otherwise.
     */
    public synchronized boolean allowRequest(String clientId) {
        long currentTime = System.currentTimeMillis();
        if (!requestTimestamps.containsKey(clientId)) {
            requestTimestamps.put(clientId, currentTime);
            return true;
        }

        long clientTimestamp = requestTimestamps.get(clientId);
        if (currentTime - clientTimestamp > timeWindowInMillis) {
            // If time window has passed, reset the count
            requestTimestamps.put(clientId, currentTime);
            return true;
        }

        // Check if the number of requests exceeds the limit within the time window
        if (requestTimestamps.size() < requestLimit) {
            requestTimestamps.put(clientId, currentTime);
            return true;
        }

        return false;
    }
}
