	package com.kush.studyplan.seventyfive.map_set;
import java.util.*;

public class DifferenceFinder {
    
    /**
     * Finds the difference between two arrays.
    */
	/**
     * Problem:
     * Given two integer arrays 'nums1' and 'nums2', find the unique elements from 'nums1'
     * that are not present in 'nums2', and vice versa.
     *
     * Intuition:
     * - Use sets to store unique elements from both arrays.
     * - Iterate through the arrays and populate the sets.
     * - Compare the sets to find unique elements present in one set but not in the other.
     *
     * Time Complexity: O(n + m), where 'n' is the length of nums1 and 'm' is the length of nums2.
     * - It involves iterating through both arrays to populate sets and compare elements.
     *
     * Space Complexity: O(n + m), where 'n' and 'm' are the number of unique elements in nums1 and nums2.
     * - Extra space is used to store unique elements in sets.
     */

	
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : nums1) {
            set1.add(num);
        }
        
        for (int num : nums2) {
            set2.add(num);
        }
        
        ans.add(findUniqueElements(set1, set2, nums1));
        ans.add(findUniqueElements(set2, set1, nums2));
        
        return ans;
    }
    
    private List<Integer> findUniqueElements(Set<Integer> set1, Set<Integer> set2, int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        for (int num : nums) {
            if (!set2.contains(num) && set1.contains(num)) {
                list.add(num);
                set1.remove(num); // Remove to avoid duplicate addition
            }
        }
        
        return list;
    }

    // Main method to test the function
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 4, 5 };
        int[] nums2 = { 3, 4, 5, 6, 7 };

        DifferenceFinder finder = new DifferenceFinder();
        List<List<Integer>> result = finder.findDifference(nums1, nums2);
        System.out.println("Unique elements from nums1: " + result.get(0)); // Output: [1, 2]
        System.out.println("Unique elements from nums2: " + result.get(1)); // Output: [6, 7]
    }
}
