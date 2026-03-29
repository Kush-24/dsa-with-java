package com.kush.studyplan.seventyfive.slidingwindow;
// Problem:
// Calculate the maximum average of subarrays of length 'k' within the 'nums' array.

// Intuition Behind the Approach:
// - Calculate the sum of the first 'k' elements to start the window.
// - Slide the window by subtracting the leftmost element and adding the next element.
// - Update the maximum average if a new higher average is found.

// Time Complexity: O(n)
// - The algorithm iterates through the 'nums' array once to slide the window.
// - Thus, the time complexity is linear with respect to the length of the 'nums' array.

public class MaxAverageOfSubarray {
    public static void main(String[] args) {
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;

        double maxAverage = findMaxAverage(nums, k);
        System.out.println("Maximum Average of Subarrays of Length " + k + ": " + maxAverage);
    }

    public static double findMaxAverage(int[] nums, int k) {
        double maxAvg = Integer.MIN_VALUE;
        double currSum = 0;
        int left = 0;

        for (int i = 0; i < k; i++) {
            currSum += nums[i];
        }

        maxAvg = currSum / k;

        for (int right = k; right < nums.length; right++) {
            currSum += nums[right] - nums[left];
            maxAvg = Math.max(maxAvg, currSum / k);
            left++;
        }

        return maxAvg;
    }
}
