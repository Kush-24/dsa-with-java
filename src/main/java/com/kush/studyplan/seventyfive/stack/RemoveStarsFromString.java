package com.kush.studyplan.seventyfive.stack;
import java.util.Stack;

class RemoveStarsFromString {
    // Problem: Remove '*' characters along with the preceding non-'*' character in the given string.
    // For example, if the input string is "ab**cd**e*", the output should be "ace*".
    
    // Intuition: Utilize a stack to process the string characters.
    // Iterate through each character in the string:
    // - If the current character is '*', and the stack is not empty, pop the character from the stack.
    // - Otherwise, push non-'*' characters onto the stack.
    // Reconstruct the string by popping characters from the stack and then reverse it to get the final output.
    
    // Time Complexity: O(N), where N is the length of the input string 's'.
    //                  The algorithm traverses the input string once.
    // Space Complexity: O(N), where N is the length of the input string 's'.
    //                   The space used is proportional to the length of the input string due to the stack.
    
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        
        // Iterate through each character in the input string
        for (char ch : s.toCharArray()) {
            if (ch == '*' && !st.isEmpty()) {
                st.pop(); // Remove the character from the stack if it's '*' and the stack is not empty
            } else {
                st.add(ch); // Add characters to the stack other than '*'
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        // Reconstruct the string by popping characters from the stack
        while (!st.empty()) {
            sb.append(st.pop());
        }
        
        return sb.reverse().toString(); // Reverse the string to get the final output
    }
    
    // Main method to test the 'removeStars' function
    public static void main(String[] args) {
        RemoveStarsFromString solution = new RemoveStarsFromString();
        String input = "ab**cd**e*";
        System.out.println("Input: " + input);
        System.out.println("Output: " + solution.removeStars(input)); // Output: "ace*"
    }
}
