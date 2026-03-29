package com.kush.studyplan.seventyfive.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Problem:
 * The `RecentCounter` class is designed to count the number of recent requests within a time frame.
 * It takes in timestamps and returns the number of requests made in the last 3000 milliseconds.
 *
 * Intuition:
 * - Utilizes a deque (double-ended queue) to efficiently manage timestamps.
 * - The `ping` method adds a timestamp to the deque.
 * - Removes timestamps older than `t - 3000` milliseconds to maintain the 3000ms window.
 * - Returns the count of requests within the specified time frame.
 *
 * Time Complexity: O(1) amortized for the `ping` method.
 * Space Complexity: O(N) for the deque to store timestamps.
 * 
Yes, the time complexity for the `ping` method in the `RecentCounter` class is considered to be O(1) in the worst case. This is because the while loop, which removes elements older than `t - 3000` milliseconds, 
doesn’t affect the overall time complexity significantly.
The while loop iterates only for elements that fall outside the 3000ms window. 
In the worst case, this loop will process a limited number of elements from the deque (most often just a single element). 
Hence, it doesn’t grow proportionally with the input size or 'N', 
and the time complexity remains constant, making it O(1) in the worst case scenario.

*
*/
public class RecentCounter {
    Deque<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    /**
     * Add a new request to the timestamp queue and count recent requests within 3000ms.
     *
     * @param t The timestamp of the new request.
     * @return The count of requests made within the last 3000 milliseconds.
     */
    public int ping(int t) {
        queue.add(t);

        // Remove requests older than t - 3000 milliseconds
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll(); // Remove elements until within the time frame
        }

        return queue.size();
    }

    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1)); // Output: 1
        System.out.println(counter.ping(100)); // Output: 2
        System.out.println(counter.ping(3001)); // Output: 1
        System.out.println(counter.ping(3002)); // Output: 2
    }
}
