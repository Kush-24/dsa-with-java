package com.kush.studyplan.seventyfive.stack;

import java.util.Stack;

public class DecodeString {
	/*
	 * The time complexity of the given algorithm is O(N), where N is the length of the input string.
	 * This complexity arises from the linear iteration through each character in the input string,
	 * O(N), and the stack operations and building of the answer string also contribute 
	 *  linearly to the overall time complexity.
	 */
	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		//System.out.println(decodeString("3[a2[c]]"));
		//System.out.println(decodeString("2[abc]3[cd]ef"));
	}

	    public static String decodeString(String s) {
	        // StringBuilder to store the final decoded string
	        StringBuilder ans = new StringBuilder();
	        // Stack to handle the decoding process
	        Stack<Character> st = new Stack<>();
	        
	        // Iterate through each character in the input string
	        for (char ch : s.toCharArray()) {
	            if (ch != ']') {
	                // If not ']', push the character onto the stack
	                st.push(ch);
	            } else {
	                // Extracting characters inside the brackets
	                StringBuilder tempString = new StringBuilder();
	                while (!st.isEmpty() && st.peek() != '[') {
	                    // Build the substring inside the brackets
	                    tempString.insert(0, st.pop());
	                }
	                
	                // Pop the '['
	                st.pop();
	                
	                // Extracting the number
	                StringBuilder numStr = new StringBuilder();
	                while (!st.isEmpty() && Character.isDigit(st.peek())) {
	                    // Build the number preceding '['
	                    numStr.insert(0, st.pop());
	                }
	                int repeat = Integer.parseInt(numStr.toString());
	                
	                // Repeating the substring and pushing it back to the stack
	                String strToRepeat = tempString.toString();
	                while (repeat > 0) {
	                    for (char c : strToRepeat.toCharArray()) {
	                        // Repeat and push characters back onto the stack
	                        st.push(c);
	                    }
	                    repeat--;
	                }
	            }
	        }
	        
	        // Building the answer string from the stack
	        while (!st.isEmpty()) {
	            // Pop characters from the stack and build the final answer
	            ans.insert(0, st.pop());
	        }
	        
	        return ans.toString();
	    }

}
