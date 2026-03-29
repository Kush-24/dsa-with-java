package com.kush.studyplan.seventyfive.arraystring;
class ReverseWords {
    public static void main(String[] args) {
        // Sample input string
        String input = "a good   example";

        // Calling reverseWords method and printing the result
        String result = reverseWords(input);
        System.out.println("Reversed Words: " + result);
    }

    /*
    Problem:
    Reverse the order of words in a given string.

    Logic Explanation:
    - Trim the input string and split it by one or more whitespaces to get individual words.
    - Create a StringBuilder 'sb' to store the reversed order of words.
    - Iterate through the words array in reverse order:
        - Append each word to the StringBuilder 'sb'.
        - Add a space after each word (except for the last word).
    - Return the reversed words as a string.

    Key Points:
    - Splits the input string into words using whitespace as a delimiter.
    - Reverses the order of words while preserving the spaces between them.
    */

    public static String reverseWords(String s) {
        String[] str = s.trim().split("\\s+"); // Split the string by one or more whitespaces
        StringBuilder sb = new StringBuilder();

        // Iterate through the words array in reverse order
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]); // Append each word to the StringBuilder
            if (i > 0) {
                sb.append(" "); // Add a space after each word (except for the last word)
            }
        }
        return sb.toString(); // Return the reversed words as a string
    }
}
