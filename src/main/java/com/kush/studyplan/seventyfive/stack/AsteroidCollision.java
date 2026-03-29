package com.kush.studyplan.seventyfive.stack;
import java.util.*;

class AsteroidCollision {

    /**
     * Given an array of integers representing asteroids moving to the right (+) or left (-),
     * determine the final state of asteroids after all collisions.
     * 
     * Intuition:
     * - Use a stack to simulate asteroid collisions by checking each asteroid's direction.
     * - Positive asteroids always move right and are safe; push them to the stack.
     * - Negative asteroids collide with the top of the stack until destroyed or reach a positive asteroid.
     * 
     * 
     * Time Complexity: O(N), where N is the number of asteroids in the input array.
     * Space Complexity: O(N) for the stack used to track asteroid collisions.
     */
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for (int val : asteroids) {
            if (st.isEmpty() || val > 0) {
                st.push(val); // Push positive asteroid or if stack is empty
            } else {
                while (!st.isEmpty() && st.peek() > 0 && st.peek() < Math.abs(val)) {
                    st.pop(); // Destroy asteroids in collision if the current one is larger
                }
                if (!st.isEmpty() && st.peek() == Math.abs(val)) {
                    st.pop(); // Destroy asteroids in collision if they are equal
                } else if (st.isEmpty() || st.peek() < 0) {
                    st.push(val); // Add the negative asteroid when it survives the collision
                }
            }
        }
        
        int[] ans = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            ans[i] = st.pop(); // Populate the result array
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        AsteroidCollision solution = new AsteroidCollision();
        int[] result = solution.asteroidCollision(asteroids);
        System.out.println(Arrays.toString(result)); // Output: [5, 10]
    }
}
