package com.kush.studyplan.seventyfive.revision;

import java.util.Stack;

public class DecodeString {
	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		//System.out.println(decodeString("3[a2[c]]"));
		//System.out.println(decodeString("2[abc]3[cd]ef"));
	}

	public static String decodeString(String s) {
	    StringBuilder ans = new StringBuilder();
	    Stack<Integer> number = new Stack<>();
	    Stack<StringBuilder> string = new Stack<>();

	    for (char ch : s.toCharArray()) {
	      if(Character.isDigit(ch)) {
	    	   number.add(ch-'0');
	      } else {
	    	 if(ch!=']') {
	    	 string.add(new StringBuilder(ch));
	    	 }else {
	    	    StringBuilder ts=new StringBuilder();
	    	   while(!string.empty() && !string.peek().equals("[")) {
	    		   ts.insert(0, string.pop());
	    	   } 
	    	   //get the number from stack
	    	   int num=number.pop();
	    	   while(num > 0) {
	    		   ts.append(ts);
	    		   num--;
	    	   }
	    	   System.out.println("ts "+ts);
	    	   string.add(ts);
	    	 }
	      }
	      System.out.println(number.toString());
	      System.out.println(string.toString());

	    }
	   return ans.toString();
	}

}
