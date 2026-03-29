package com.kush.studyplan.seventyfive.prefixsum;

/**
 * Pivot Index:
 * Given an integer array 'nums', find the index where the sum of the numbers to the left of the index
 * is equal to the sum of numbers to the right of the index. If no such index exists, return -1.
 * 
 * Intuition:
 * - Calculate the total sum of the array to determine the right sum while traversing from left to right.
 * - Use a leftSum variable to calculate the left sum as you iterate through the array.
 * - Compare leftSum with the remaining right sum to find the pivot index.
 * 
 * Time Complexity: O(N), where N is the number of elements in the 'nums' array.
 * Space Complexity: O(1), constant extra space is used.
 */
public class PivotIndex {

    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        PivotIndex solution = new PivotIndex();
        System.out.println(solution.pivotIndex(nums)); // Output: 3
    }
    

        public int pivotIndexWithExtraSpace(int[] nums) {
            int[] left = new int[nums.length];
            int[] right = new int[nums.length];

            // Calculating prefix sums for left and right arrays
            left[0] = 0;
            for (int i = 1; i < nums.length; i++) {
                left[i] = left[i - 1] + nums[i - 1];
            }

            right[nums.length - 1] = 0;
            for (int i = nums.length - 2; i >= 0; i--) {
                right[i] = right[i + 1] + nums[i + 1];
            }

            for (int i = 0; i < nums.length; i++) {
                if (left[i] == right[i]) {
                    return i;
                }
            }

            return -1;
        }


    public int pivotIndex(int[] nums) {
/*
leftSum keeping all the sum till ith index. 
For finding the rightSum, we can subtract the leftSum from the totalSum
*/
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (leftSum == totalSum - leftSum - nums[i]) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }
}
