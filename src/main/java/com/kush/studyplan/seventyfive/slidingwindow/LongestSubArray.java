package com.kush.studyplan.seventyfive.slidingwindow;
/**
 * // Longest subarray of 1's after deleting one element 
 * Problem: Given an integer array 'nums', find the length of the longest contiguous subarray containing only 1's after removing at most one 0.
 * 
 * Intuition:
 * - Use a sliding window technique to iterate through the array 'nums'.
 * - Initialize pointers 'st' and 'end' to mark the start and end of the window, 'max' to track the maximum length, and 'numDeleted' to count zeros.
 * - While traversing the array, increment 'end' and count zeros.
 * - If the count of zeros exceeds 1, shrink the window from the left side ('st') while maintaining the condition of removing at most one zero.
 * - Calculate the window size and update 'max' based on the valid subarray length.
 * - Adjust 'max' if the count of zeros is 0 at the end.
 *
 * Time Complexity: O(N), where N is the number of elements in the 'nums' array.
 * Space Complexity: O(1), constant extra space is used.
 */
public class LongestSubArray {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 0, 1, 1, 1, 0, 1, 1 };

        LongestSubArray solution = new LongestSubArray();
        System.out.println(solution.longestSubarray(nums)); // Output: 5
    }

    public int longestSubarray(int[] nums) {
        int st = 0, end = 0, max = 0;
        int numDeleted = 0;

        while (end < nums.length) {
            // Increment zero count if the current element is 0
            if (nums[end] == 0)
                numDeleted++;

            // Shrink the window from the left side while ensuring at most one zero is removed
            while (numDeleted > 1 && st < end) {
                // Decrement zero count when moving the start pointer
                if (nums[st] == 0) {
                    numDeleted--;
                }
                st++;
            }
            // Calculate the window size and adjust for one zero
            int windowSize = end - st + 1;
            if (numDeleted == 1)
                windowSize--;

            max = Math.max(max, windowSize);
            end++;
        }

        // Adjust 'max' if the count of zeros is 0 at the end
        if (numDeleted == 0)
            max--;

        return max;
    }
    
    public static int longestSubarray2(int[] nums) {
        int maxLength = 0;
        int left = 0;
        int countZero = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                countZero++;
            }

            while (countZero > 1) {
                if (nums[left] == 0) {
                    countZero--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength - 1; // Subtract 1 as we're allowed to remove only one element
    }
}
