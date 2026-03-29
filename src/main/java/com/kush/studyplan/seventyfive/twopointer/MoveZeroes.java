package com.kush.studyplan.seventyfive.twopointer;
class MoveZeroes {
    public static void main(String[] args) {
        // Sample input array
        int[] nums = {0, 1, 0, 3, 12};

        // Move zeroes to the end of the array
        moveZeroes(nums);

        // Display the modified array
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    /*
    Problem:
    Moves all zeroes in the array to the end while maintaining the order of non-zero elements.

    Logic Explanation:
    - Use two pointers 'fill' and 'curr' to keep track of the position to fill non-zero elements and the current element in the array, respectively.
    - Iterate through the array:
        - If the current element is non-zero, place it at the 'fill' position and increment 'fill'.
    - After the first iteration, all non-zero elements are moved to the front of the array.
    - Fill the remaining positions with zeroes starting from 'fill' till the end of the array.

    Key Points:
    - Uses two pointers to track non-zero elements and zeroes.
    - Preserves the relative order of non-zero elements while moving zeroes to the end.

    */

    public static void moveZeroes(int[] nums) {
        int fill = 0; // Pointer to fill non-zero elements
        int curr = 0; // Pointer for the current element

        while (curr < nums.length) {
            if (nums[curr] != 0) {
                nums[fill++] = nums[curr]; // Move non-zero elements to the front
            }
            curr++;
        }

        // Fill the remaining positions with zeroes
        while (fill < nums.length) {
            nums[fill++] = 0;
        }
    }
}
