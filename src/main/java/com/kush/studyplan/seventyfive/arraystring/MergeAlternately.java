package com.kush.studyplan.seventyfive.arraystring;
class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        /*
        Problem: Merge two strings alternatively, taking one character from each string in turns.

        Algorithm/Key Points:
        - Create a StringBuilder 'sb' to construct the merged string.
        - Determine the shorter string among 'word1' and 'word2' and store it in 'ss'.
        - Initialize an index 'i' to 0 for traversing the shorter string.
        - Append characters alternatively from 'word1' and 'word2' until reaching the end of the shorter string 'ss'.
        - Check the longer string and append the remaining characters to 'sb'.
        - Return the merged string 'sb'.

        Time Complexity: O(N), where N is the length of the shorter string between 'word1' and 'word2'.
        Space Complexity: O(N), the space used by the StringBuilder 'sb' to store the merged string.
        */

        // StringBuilder to store the merged string
        StringBuilder sb = new StringBuilder();

        // Determine the shorter string among 'word1' and 'word2'
        String ss = word1.length() < word2.length() ? word1 : word2;
        int i = 0;

        // Append characters alternatively from 'word1' and 'word2'
        while (i < ss.length()) {
            sb.append(word1.charAt(i)); // Append character from 'word1'
            sb.append(word2.charAt(i++)); // Append character from 'word2'
        }

        // Append the remaining characters from the longer string
        if (ss.equals(word1)) {
            sb.append(word2.substring(i)); // Append remaining characters from 'word2'
        } else {
            sb.append(word1.substring(i)); // Append remaining characters from 'word1'
        }

        // Return the merged string
        return sb.toString();
    }

    public static void main(String[] args) {
        // Creating an instance of MergeAlternately class
        MergeAlternately solution = new MergeAlternately();

        // Sample inputs
        String word1 = "abc";
        String word2 = "def";

        // Testing mergeAlternately method with sample inputs
        String merged = solution.mergeAlternately(word1, word2);
        System.out.println("Merged string: " + merged); // Output: "adbecf"
    }
}
