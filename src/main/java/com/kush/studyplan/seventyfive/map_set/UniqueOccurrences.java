package com.kush.studyplan.seventyfive.map_set;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOccurrences {

    /**
	 * Problem: Given an integer array 'arr', determine whether the frequency of
	 * each value in the array is unique.
	 *
	 * Intuition: 
	 * - Utilize a HashMap to count the frequency of each element in the
	 * array. 
	 * - Store the frequency values in a Set to check uniqueness. 
	 * - Iterate through the frequency values and check if any value is already present in the
	 * Set.
	 * 
	 * If the frequency of the nums[i] is unique then true else false.
	 * Map<nums[i],occurence> Set for checking where occurence is unique or not
	 *
	 * Time Complexity: O(n), where 'n' is the length of the input array 'arr'. - It
	 * involves iterating through the array and the frequency map.
	 *
	 * Space Complexity: O(n), where 'n' is the number of unique frequencies in the
	 * map. - Extra space is used to store frequency counts in the map and set.
	 */

	 public boolean uniqueOccurrences(int[] arr) {
	        Map<Integer,Integer> map=new HashMap<>();
	        for(int num:arr){
	            map.put(num,map.getOrDefault(num,0)+1);
	        }
	        Set<Integer> set=new HashSet<>();
	        for(int key:map.keySet()){
	           if(set.contains(map.get(key)))
	              return false;
	          set.add(map.get(key));
	        }
	        return true;
	    }
}