package com.ecararus.algs.stringManipulation;

/**
 * Find the longest substring that is a palindrome.
 *
 * Plan:
 * 1. Create a method that takes a string as input.
 * 2. Create a variable to store the longest palindrome.
 * 3. Loop through the string and check for palindromes.
 * 4. If a palindrome is found, update the longest palindrome.
 * 5. Return the longest palindrome.
 */
public class LongestPalindromicSubstring {

    public String findLongestPalindromicSubstring(String s) {
        int n = s.length();
        if (n == 0) return "";

        boolean[][] dp = new boolean[n][n];
        int maxLength = 1;
        int start = 0;

        // All substrings of length 1 are palindromes
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Check for substrings of length 2
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for substrings of length greater than 2
        for (int length = 3; length <= n; length++) {
            for (int i = 0; i < n - length + 1; i++) {
                int j = i + length - 1;
                if (dp[i + 1][j - 1] && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (length > maxLength) {
                        start = i;
                        maxLength = length;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String s = "babad";
        System.out.println("Longest palindromic substring: " + lps.findLongestPalindromicSubstring(s)); // Output: "bab" or "aba"
    }

}
