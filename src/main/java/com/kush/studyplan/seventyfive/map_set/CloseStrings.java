package com.kush.studyplan.seventyfive.map_set;
import java.util.Arrays;

public class CloseStrings {
	 //Input: word1 = "abc", word2 = "bca" Output: true
	
	/* Intuition: The key observation here is that two strings are close if and only if they have 
	 * the same set of characters with the same frequency. Additionally, the characters need to
	 *  be interchangeable using the given operations.
	 */

    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char ch : word1.toCharArray()) {
            freq1[ch - 'a']++;
        }

        for (char ch : word2.toCharArray()) {
            freq2[ch - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if ((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }

    public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "bca";

        boolean result = closeStrings(word1, word2);

        if (result) {
            System.out.println("The words are close.");
        } else {
            System.out.println("The words are not close.");
        }
    }
}
