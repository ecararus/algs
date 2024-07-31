package com.ecararus.algs.stringManipulation;

/**
 * Check if one string is a rotation of another string.
 *
 * Plan:
 * 1. Create a method that takes two strings as input.
 * 2. Check if the length of the strings is the same.
 * 3. Concatenate the first string with itself.
 * 4. Check if the second string is a substring of the concatenated string.
 * 5. Return true if the second string is a rotation of the first string.
 * 6. Return false otherwise.
 */
public class StringRotation {

    // Time complexity: O(n), where n is the length of the strings.
    // Space complexity: O(n), where n is the length of the strings.
    // This method checks if one string is a rotation of another string.
    public boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String concatenated = s1 + s1;
        return concatenated.contains(s2);
    }

    public static void main(String[] args) {
        StringRotation sr = new StringRotation();
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println("Is rotation: " + sr.isRotation(s1, s2)); // Output: true
    }

}
