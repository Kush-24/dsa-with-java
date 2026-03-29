package com.kush.studyplan.seventyfive.arraystring;
import java.util.ArrayList;
import java.util.List;

class KidsWithCandies {
    public static void main(String[] args) {
        // Sample inputs
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;

        // Calling kidsWithCandies method and printing the result
        List<Boolean> result = kidsWithCandies(candies, extraCandies);
        System.out.println("Kids with Greatest Number of Candies: " + result);
    }

    /*
    Problem:
    Given an array 'candies' representing the number of candies each kid has and an integer 'extraCandies',
    determine if the kid can have the greatest number of candies after adding 'extraCandies'.

    Logic Explanation:
    - Find the maximum number of candies among all kids.
    - Check if each kid can have the greatest number of candies by adding 'extraCandies' to their candies.
    - If a kid can achieve the greatest number of candies or surpass it, mark as 'true' in the result list.
    - Otherwise, mark as 'false' in the result list.

    Key Points:
    - Finds the maximum number of candies among all kids.
    - Determines if each kid can have the greatest number of candies by adding 'extraCandies'.
    - Returns a list indicating whether each kid can achieve the greatest number of candies.
    */

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxValue = 0;
        List<Boolean> ans = new ArrayList<>();

        // Find the maximum number of candies among all kids
        for (int candy : candies)
            maxValue = Math.max(maxValue, candy);

        // Check if each kid can have the greatest number of candies by adding 'extraCandies'
        for (int candy : candies) {
            if (candy + extraCandies >= maxValue) {
                ans.add(true); // If true, kid can have the greatest number of candies
            } else {
                ans.add(false); // If false, kid cannot have the greatest number of candies
            }
        }
        return ans; // Return the result list
    }
}
