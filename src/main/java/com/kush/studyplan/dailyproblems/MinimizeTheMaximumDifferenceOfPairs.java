package com.kush.studyplan.dailyproblems;

import java.util.Arrays;



// https://leetcode.com/problems/minimize-the-maximum-difference-of-pairs/?envType=daily-question&envId=2025-06-13
public class MinimizeTheMaximumDifferenceOfPairs {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);

        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        while (left < right) {
            int mid = (left + right) / 2;
            if (canFormPairs(nums, p, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int count = 0;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                count++;
                i += 2; // skip both used indices
            } else {
                i++;
            }
        }
        return count >= p;
    }

    public static void main(String[] args){
        MinimizeTheMaximumDifferenceOfPairs obj = new MinimizeTheMaximumDifferenceOfPairs ();
        System.out.println ( obj.minimizeMax(new int[]{1,1,0,3}, 2));
        System.out.println ( obj.minimizeMax((new int[]{4 , 2 , 1 , 2}), 1));
        System.out.println ( obj.minimizeMax(new int[]{3,4,2,3,2,1,2},3));
        System.out.println ( obj.minimizeMax(new int[]{1,1,0,3},2));
    }
}
