package com.kush.studyplan.seventyfive.arraystring;
class IncreasingTriplet {
    public static void main(String[] args) {
        // Sample input array
        int[] nums = {1, 2, 3, 4, 5};

        // Check for an increasing triplet and print the result
        boolean result = increasingTriplet(nums);
        System.out.println("Increasing Triplet Existence: " + result);
    }

    /*
    Problem:
    Determine if there exists an increasing triplet in the given array.

    Logic Explanation:
    - Maintain two variables 'firstMin' and 'secondMin' initialized to the maximum integer value.
    - Iterate through the array:
        - If a number is less than or equal to 'firstMin':
            - Update 'firstMin' with this number to ensure we have the smallest encountered number so far.
        - Else if the number is less than or equal to 'secondMin':
            - Update 'secondMin' with this number to maintain the second smallest encountered number so far.
        - If a number is greater than both 'firstMin' and 'secondMin':
            - It indicates the existence of an increasing triplet.

    Reasoning behind Tracking Smallest and Second Smallest:
    - 'firstMin' is updated whenever a number smaller than or equal to 'firstMin' is found, ensuring it holds the smallest encountered value.
    - 'secondMin' is updated whenever a number greater than 'firstMin' but smaller than or equal to 'secondMin' is found, maintaining the second smallest value encountered.
    - The existence of an increasing triplet relies on finding numbers greater than both 'firstMin' and 'secondMin'.

    */

    public static boolean increasingTriplet(int[] nums) {
        int firstMin = Integer.MAX_VALUE;  // Smallest number encountered so far
        int secondMin = Integer.MAX_VALUE; // Second smallest number encountered so far

        for (int num : nums) {
            if (num <= firstMin) {
                // Update 'firstMin' if the number is smaller than or equal to 'firstMin'
                firstMin = num;
            } else if (num <= secondMin) {
                // Update 'secondMin' if the number is smaller than or equal to 'secondMin'
                secondMin = num;
            } else {
                // If a number is greater than both 'firstMin' and 'secondMin', an increasing triplet exists
                return true;
            }
        }

        // No increasing triplet found
        return false;
    }
}
