package com.ecararus.algs.stringManipulation;

/**
 * Remove duplicate characters from a string.
 *
 * Plan:
 * 1. Create a boolean array of size 256 to keep track of characters.
 * 2. Iterate through the string and set the boolean array to true for each character.
 * 3. Create a StringBuilder to store the unique characters.
 * 4. Iterate through the boolean array and append the character to the StringBuilder if the value is true.
 * 5. Return the StringBuilder as a string.
 */
public class RemoveDuplicates {

    public String removeDuplicates(String str) {
        boolean[] charSet = new boolean[256];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!charSet[c]) {
                charSet[c] = true;
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicates remover = new RemoveDuplicates();
        String testStr = "aabbccddeeff";
        System.out.println("String after removing duplicates: " + remover.removeDuplicates(testStr)); // Output: "abcdef"
    }
}
