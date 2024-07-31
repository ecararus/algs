package com.ecararus.algs.stringManipulation;

/**
 * Reverse the characters in a string.
 *
 * Plan:
 * 1. Create a method that takes a string as input.
 * 2. Create a char array to store the characters of the string.
 * 3. Iterate through the string and store the characters in the char array in reverse order.
 * 4. Return the reversed string.
 *
 */
public class ReversingString {

    public String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        ReversingString reverser = new ReversingString();
        String testStr = "hello";
        System.out.println("Reversed string: " + reverser.reverseString(testStr)); // Output: "olleh"
    }
}
