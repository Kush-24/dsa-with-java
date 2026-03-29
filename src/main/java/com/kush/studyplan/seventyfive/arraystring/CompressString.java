package com.kush.studyplan.seventyfive.arraystring;
class CompressString {
    public static void main(String[] args) {
        // Sample input array
        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};

        // Compress the character array and print the compressed length
        int compressedLength = compress(chars);
        System.out.println("Compressed Length: " + compressedLength);
    }

    /*
    Problem:
    Compresses a character array by replacing repeated characters with the character itself followed by the count of its occurrences.

    Logic Explanation:
    - Use a StringBuilder 'sb' to build the compressed string.
    - Iterate through the input 'chars':
        - Check for consecutive occurrences of each character.
        - Append compressed characters ('char' + 'count') to the StringBuilder 'sb'.

    Key Points:
    - Builds a compressed string using StringBuilder.
    - Appends the character itself and its count for consecutive occurrences.

    */

    public static int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]); // Append the first character
        

        int i = 1; // Start iterating from the second character
        int cnt = 1; // Counter for consecutive occurrences

        while (i < chars.length) {
            if (chars[i] == chars[i - 1]) {
                // Increment counter for consecutive occurrences of the same character
                cnt++;
            } else {
                // Append the character and its count to the StringBuilder 'sb'
                if (cnt > 1) {
                    sb.append(cnt);
                }
                // Reset counter for a new character
                sb.append(chars[i]);
                cnt = 1;
            }
            i++;
        }

        // what if control never goes in else part i.e "aaaaaaaa"
        if (cnt > 1) {
            sb.append(cnt);
        }

        // Convert StringBuilder to a string and update the input array 'chars'
        String compressedString = sb.toString();
        for (int j = 0; j < compressedString.length(); j++) {
            chars[j] = compressedString.charAt(j);
        }

        System.out.println(compressedString); // Print the compressed string
        return compressedString.length(); // Return the length of the compressed string
    }
}
