package com.kush.studyplan.others;

import java.util.*;

public class MinFrequencyCharacter {
public static void main(String[] args) {
	findMinFreqChar("cdadcdaaa");
}

private static void findMinFreqChar(String string) {
	Map<Character,Integer> map=new HashMap<>();
	for(char ch:string.toCharArray())
		 map.put(ch, map.getOrDefault(ch, 0)+1);
	
	//for it based on the values. 
    List<Map.Entry<Character,Integer>>	list=new ArrayList<>(map.entrySet());
    //Collections.sort(list,Map.Entry.comparingByValue());
    Collections.sort(list, (entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()));
    System.out.println(list);
    findMinFreqChar2(string);
}

private static void findMinFreqChar2(String string) {
    int[] freq = new int[62]; // 26 for uppercase, 26 for lowercase, 10 for digits
    int base = 'A'; // ASCII value of 'A'
    for (char ch : string.toCharArray()) {
        if (Character.isUpperCase(ch)) {
            freq[ch - base]++;
        } else if (Character.isLowerCase(ch)) {
            freq[ch - 'a' + 26]++;
        } else if (Character.isDigit(ch)) {
            freq[ch - '0' + 52]++;
        }
    }
    System.out.println(Arrays.asList(freq));
    
}
}
