package com.kush.studyplan.seventyfive.twopointer;
import java.util.HashMap;
import java.util.Map;

public class MaxNumberofKSumPair {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5}; // Sample input array
        int k = 5; // Target sum

        // Calculate the maximum number of operations (pairs) summing to k
        int maxOps = maxOperations(nums, k);
        System.out.println("Maximum Operations: " + maxOps);
    }

    /*
    Problem:
    Find the maximum number of pairs in nums that sum up to k.

    Intuition:
    - Use a hashmap to count the frequency of each number in nums.
    - Traverse nums and check for pairs (num, k - num) to form sum k.
    - Decrement frequencies when pairs are found.

    Time Complexity: O(N)
    - Two passes through nums: once to create frequency map and another to find pairs.
    - Both passes involve linear time operations.

    Space Complexity: O(N)
    - Additional space used by the hashmap to store frequencies of nums elements.
    */

    public static int maxOperations(int[] nums, int k) {
        int cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();

        // Count frequency of each number in nums
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Iterate through nums to find pairs summing to k
        for (int num : nums) {
            int freqNum = map.getOrDefault(num, 0);
            int freqComp = map.getOrDefault(k - num, 0);
         // If both num is same than frequency counts should atleast 2 i.e > 1
         // sum= 6 , num =3 then sum - num is also 3. (3 + 3) two three is required for  making sum 6.
            if ((num == k - num && freqNum > 1) || (num != k - num && freqNum > 0 && freqComp > 0)) {
                map.put(num, freqNum - 1);
                map.put(k - num, freqComp - 1);
                cnt++;
            }
        }

        return cnt;
    }
}
