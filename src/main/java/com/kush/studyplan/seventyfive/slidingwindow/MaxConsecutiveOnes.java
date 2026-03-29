package com.kush.studyplan.seventyfive.slidingwindow;

/**
 * Problem: Given an array nums containing only 0s and 1s, and an integer k, 
 * find the maximum number of consecutive 1's in the array if you can flip at most k 0's.
 *
 * Intuition:
 * - Utilizes a sliding window technique to find the maximum number of consecutive ones 
 *   by allowing at most 'k' zeros to be flipped.
 * - Initialize pointers 'st' and 'end' to mark the start and end of the window, 
 *   'zeroCnt' to count zeros, and 'max' to track the maximum length.
 * - Iterate through the array, increment 'end' and expand the window while counting zeros.
 * - If the count of zeros exceeds 'k', shrink the window from the left side 
 *   to maintain the condition of flipping at most 'k' zeros.
 * - Update the 'max' length of consecutive ones found during the iteration.
 *
 * Time Complexity: O(N), where N is the number of elements in the nums array.
 * Space Complexity: O(1), constant extra space is used.
 */
public class MaxConsecutiveOnes {
	
    public int longestOnes(int[] nums, int k) {
        int st = 0, end = 0;
        int zeroCnt = 0, max = 0;
        while (end < nums.length) {
            if (nums[end] == 0) {
                zeroCnt++;
            }
            // If zero count is more than the allowed flips counts
            // make the starting point of the window to the first zero which include in window
            while (zeroCnt > k && st <= end) {
                if (nums[st] == 0) {
                    zeroCnt--;
                }
                st++;
            }
            max = Math.max(max, end - st + 1); // calculation the window side with max value
            end++;
        }
        return max;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 1, 1, 1, 0, 1, 1};
        int k = 2;
        MaxConsecutiveOnes solution = new MaxConsecutiveOnes();
        System.out.println(solution.longestOnes(nums, k)); // Output: 6
    }
}
