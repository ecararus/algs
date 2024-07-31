package com.ecararus.algs.stringManipulation;

/**
 * Find the longest subsequence common to two strings.
 *
 * Plan:
 * 1. Create a method that takes two strings as input.
 * 2. Create a 2D array to store the length of the longest common subsequence.
 * 3. Loop through the strings and compare the characters.
 * 4. If the characters match, increment the length of the longest common subsequence.
 * 5. If the characters do not match, take the maximum of the previous longest common subsequence.
 * 6. Return the length of the longest common subsequence.
 *
 */
public class LongestCommonSubsequence {

    // Time complexity: O(m*n), where m is the length of str1 and n is the length of str2.
    // Space complexity: O(m*n), where m is the length of str1 and n is the length of str2.
    // This method finds the length of the longest common subsequence of two strings.
    public int findLongestCommonSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        // Fill in the 2D array with the length of the longest common subsequence
        // dp[i][j] represents the length of the longest common subsequence of the first i characters of str1
        // and the first j characters of str2
        // If the characters at the current positions are the same, the length of the longest common subsequence
        // is one more than the length of the longest common subsequence of the previous characters
        // (dp[i][j] = dp[i-1][j-1] + 1)
        // Otherwise, the length of the longest common subsequence is the maximum of the following:
        // 1. The length of the longest common subsequence of the previous characters of str1 and the current characters of str2
        // (dp[i][j] = dp[i-1][j])
        // 2. The length of the longest common subsequence of the current characters of str1 and the previous characters of str2
        // (dp[i][j] = dp[i][j-1])
        // The final value in the bottom-right corner of the 2D array will be the length of the longest common subsequence
        // of the entire first string and the entire second string
        // Time complexity: O(m*n), where m is the length of str1 and n is the length of str2
        // Space complexity: O(m*n)
        // Reference: https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
        // Reference: https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
        // Reference: https://leetcode.com/problems/longest-common-subsequence/
        // Reference: https://www.youtube.com/watch?v=NnD96abizww
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String str1 = "abcde";
        String str2 = "ace";
        System.out.println("Length of longest common subsequence: " + lcs.findLongestCommonSubsequence(str1, str2)); // Output: 3
    }

}
