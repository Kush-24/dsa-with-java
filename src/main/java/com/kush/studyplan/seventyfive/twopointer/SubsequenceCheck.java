package com.kush.studyplan.seventyfive.twopointer;
class SubsequenceCheck {
    public static void main(String[] args) {
        // Sample inputs
        String s = "abc";
        String t = "ahbgdc";

        // Check if s is a subsequence of t
        boolean isSubsequence = isSubsequence(s, t);
        System.out.println("Is s a subsequence of t? " + isSubsequence);
    }

    /*
    Problem:
    Determines whether string 's' is a subsequence of string 't'.

    Logic Explanation:
    - Use two pointers 'i' and 'j' to traverse through strings 's' and 't', respectively.
    - Compare characters of both strings:
        - If characters match, increment 'i' (for string 's') to move to the next character.
        - Move to the next character in string 't' regardless of whether it matches or not.
    - If 'i' reaches the end of string 's', it means 's' is a subsequence of 't'.

    Key Points:
    - Utilizes two pointers to track characters in 's' and 't'.
    - Checks whether 's' is a subsequence by character comparison.

    */

    public static boolean isSubsequence(String s, String t) {
        int i = 0; // Pointer for string 's'
        int j = 0; // Pointer for string 't'

        while (i < s.length() && j < t.length()) {
            // Compare characters of both strings
            if (s.charAt(i) == t.charAt(j)) {
                i++; // Move to the next character in string 's'
            }
            j++; // Move to the next character in string 't'
        }

        // If 'i' reaches the end of string 's', it is a subsequence of 't'
        return i == s.length();
    }
    
    public boolean isSubsequencee(String s, String t) {
        if(s.length() > t.length()) return false;
        if(s.length()==t.length()){
            return s.equals(t);
        }
          int count=0,j=0;
          for(int i=0;i<s.length();i++){
              char ch=s.charAt(i);
              while(j < t.length()){
                 if(ch==t.charAt(j++)){
                     count++;
                     break;
                 } 
              }
          }
      return s.length()==count;
      }
}
