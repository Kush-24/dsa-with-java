package com.kush.studyplan.seventyfive.arraystring;

import java.util.Arrays;

class ProductExceptSelf {
    public static void main(String[] args) {
        // Sample input array
        int[] nums = {4, 5, 1, 8, 2};

        // Calling productExceptSelf method and printing the result
        int[] result = productExceptSelf(nums);
        System.out.println("Result: " + Arrays.toString(result));
    }

    /*
    Problem:
    Compute an array where each element is the product of all elements in the original array except the element itself.

    Logic Explanation:
    - Create three arrays L, R, and ans of length 'n', where 'n' is the length of the input array 'nums'.
    - Initialize L and R arrays to store products of elements to the left and right of each element in 'nums'.
    - Populate the L array:
        - L[i] stores the product of all elements to the left of 'i' in 'nums'.
    - Populate the R array:
        - R[i] stores the product of all elements to the right of 'i' in 'nums'.
    - Compute the final result by multiplying corresponding elements from L and R arrays.

    Key Points:
    - Uses two separate arrays to store products to the left and right of each element.
    - Computes the final result array by multiplying elements from the left and right arrays.
    */

    public static int[] productExceptSelf(int[] nums) {
        // nums : 4,5,1,8,2
        int n = nums.length;
        int[] L = new int[n];
        int[] R = new int[n];
        int[] ans = new int[n];

        L[0] = 1;
        R[n - 1] = 1;

        // Compute products of elements to the left of each element
        // L : 1,4,20,20,160
        for (int i = 1; i < n; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }

        // Compute products of elements to the right of each element
        //R: 80,16,16,2,1
        for (int i = n - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }

        // Compute the final result by multiplying elements from L and R arrays
        for (int i = 0; i < n; i++) {
            ans[i] = L[i] * R[i];
        }

        return ans; // Return the final result
    }
}
