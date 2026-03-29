package com.kush.studyplan.seventyfive.twopointer;
class MaxAreaOfWater {
    public static void main(String[] args) {
        // Sample input array representing the heights of vertical lines
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};

        // Calculate the maximum area of water that can be contained
        int maxWaterArea = maxArea(height);
        System.out.println("Maximum Area of Water: " + maxWaterArea);
    }

    /*
    Problem:
    Calculate the maximum area of water that can be contained between vertical lines.

    Intuition Behind the Approach:
    - Use a two-pointer approach (left and right) to find the maximum possible area.
    - The maximum area of water is determined by the shorter vertical line and the distance between the lines.
    - By starting with the maximum possible width (initially the width of the entire array),
      we narrow down the width by moving pointers towards each other based on the height of the lines.
    - At each step, update the maximum area found until the pointers converge.

    Time Complexity: O(n)
    - The two-pointer approach traverses the height array just once, performing constant-time operations at each step.
    - The linear time complexity arises due to a single iteration through the array elements.
    */

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        // Two-pointer approach to find the maximum area of water
        while (left < right) {
            int length = right - left; // Calculate the length between lines
            int minHeight = Math.min(height[left], height[right]); // Calculate minimum height

            // Calculate the area and update maxArea if needed
            maxArea = Math.max(maxArea, length * minHeight);

            // Move pointers based on the height of lines
            if (height[left] < height[right]) {
                left++; // Move left pointer if height is smaller on the left side
            } else {
                right--; // Move right pointer if height is smaller on the right side
            }
        }

        return maxArea; // Return the maximum area of water
    }
}
