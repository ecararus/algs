package com.ecararus.algs.stringManipulation;

import java.util.Arrays;

/**
 * Anagram Check: Determines if two strings are anagrams by comparing their sorted versions or using a character count.
 *
 * Plan:
 * Define the AnagramCheck class.
 * Implement the isAnagram method to check if two strings are anagrams.
 * Sort the characters in each string and compare the sorted versions.
 * Alternatively, count the occurrences of each character in each string and compare the counts.
 *
 */
public class AnagramCheck {

    // Method 1: Using sorted versions of the strings
    public boolean isAnagramUsingSort(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        char[] charArray1 = str1.toCharArray();
        char[] charArray2 = str2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);
        return Arrays.equals(charArray1, charArray2);
    }

    // Method 2: Using character counts
    public boolean isAnagramUsingCount(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] charCount = new int[256]; // Assuming ASCII characters
        for (int i = 0; i < str1.length(); i++) {
            charCount[str1.charAt(i)]++;
            charCount[str2.charAt(i)]--;
        }
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        AnagramCheck checker = new AnagramCheck();
        String str1 = "listen";
        String str2 = "silent";
        System.out.println("Are \"" + str1 + "\" and \"" + str2 + "\" anagrams (using sort)? " + checker.isAnagramUsingSort(str1, str2)); // Output: true
        System.out.println("Are \"" + str1 + "\" and \"" + str2 + "\" anagrams (using count)? " + checker.isAnagramUsingCount(str1, str2)); // Output: true
    }
}
