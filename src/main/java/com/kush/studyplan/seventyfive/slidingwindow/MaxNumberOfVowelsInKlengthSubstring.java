package com.kush.studyplan.seventyfive.slidingwindow;
// Problem:
// Given a string 's' and an integer 'k', find the maximum number of vowels in any substring of length 'k' in 's'.

// Intuition Behind the Approach:
// - Use a sliding window approach to traverse the string 's' and count the vowels within the window of length 'k'.
// - Create a helper function to count vowels within a given string.
// - Move the window and maintain the count of vowels within the window.
// - Track the maximum vowel count found in any substring of length 'k'.

// Time Complexity: O(n)
// - The algorithm traverses the string 's' once to slide the window, performing constant-time operations at each step.
// - Thus, the time complexity is linear with respect to the length of the string 's'.

public class MaxNumberOfVowelsInKlengthSubstring {
    public int maxVowels(String s, int k) {
        int maxVowels = 0; // Store the maximum count of vowels in any substring of length 'k'

        // Count vowels in the first window of length 'k'
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                maxVowels++;
            }
        }

        int currentVowels = maxVowels; // Initialize current count of vowels
        for (int i = k; i < s.length(); i++) {
            // Slide the window and update the count of vowels
            if (isVowel(s.charAt(i - k))) {
                currentVowels--;
            }
            if (isVowel(s.charAt(i))) {
                currentVowels++;
            }

            // Update the maximum count of vowels found
            maxVowels = Math.max(maxVowels, currentVowels);
        }

        return maxVowels;
    }

    // Helper function to check if a character is a vowel
    private boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
