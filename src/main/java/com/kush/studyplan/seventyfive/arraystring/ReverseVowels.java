package com.kush.studyplan.seventyfive.arraystring;
import java.util.HashSet;
import java.util.Set;

class ReverseVowels {
    public static void main(String[] args) {
        // Sample input string
        String input = "hello world";

        // Calling reverseVowels method and printing the result
        String result = reverseVowels(input);
        System.out.println("Reversed Vowels: " + result);
            // Create an immutable Set<Character> with elements 'a' and 'e'
            Set<Character> charSet = Set.of('a', 'e');
            try {
            // we can't update immutable set
            charSet.add('k');
            } catch (Exception e) {
            	System.out.println("Exception "+e);
			}
            // Display the elements of the Set
            System.out.println("Set elements: " + charSet);
    }

    /*
    Problem:
    Reverse the vowels in a given string.

    Logic Explanation:
    - Use a two-pointer approach with left and right pointers to reverse vowels in the string.
    - Create a set 'vowels' to store vowels for efficient lookup.
    - Iterate through the string with two pointers:
        - Move the left pointer to the next vowel or end of string.
        - Move the right pointer to the previous vowel or start of string.
        - Swap the vowels found by the left and right pointers.
    - Convert the modified character array back to a string and return it.

    Key Points:
    - Uses a set for efficient vowel lookup.
    - Reverses vowels in the string using a two-pointer approach.
    - Preserves non-vowel characters' positions while reversing only vowels.
    */

    public static String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        char[] chars = s.toCharArray();

        // Set to store vowels for efficient lookup
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        // Two-pointer approach to reverse vowels
        while (left < right) {
            // Move the left pointer to the next vowel or end of string
            while (left < right && !vowels.contains(chars[left])) {
                left++;
            }
            // Move the right pointer to the previous vowel or start of string
            while (left < right && !vowels.contains(chars[right])) {
                right--;
            }

            // Swap the vowels found by the left and right pointers
            if (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
        }

        // Convert the character array back to a string
        return new String(chars);
    }
}
