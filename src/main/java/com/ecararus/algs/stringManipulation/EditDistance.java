package com.ecararus.algs.stringManipulation;

/**
 * Calculate the minimum number of operations required to convert one string into another
 * (e.g., using the Levenshtein distance).
 *
 * Plan:
 * 1. Create a 2D array of size m+1 x n+1, where m is the length of the first string and n is the length of the second string.
 * 2. Initialize the first row and column with values from 0 to m and 0 to n, respectively.
 * 3. Iterate through the 2D array and calculate the minimum number of operations required to convert one string into another.
 * 4. Return the value in the bottom-right corner of the 2D array.
 */
public class EditDistance {

    public int calculateEditDistance(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Fill in the 2D array with the minimum number of operations required to convert one string into another
        // (e.g., using the Levenshtein distance)
        // dp[i][j] represents the minimum number of operations required to convert the first i characters of str1
        // into the first j characters of str2
        // If the characters at the current positions are the same, no operation is required (dp[i][j] = dp[i-1][j-1])
        // Otherwise, we take the minimum of the following:
        // 1. Insert a character (dp[i][j] = dp[i][j-1] + 1)
        // 2. Delete a character (dp[i][j] = dp[i-1][j] + 1)
        // 3. Replace a character (dp[i][j] = dp[i-1][j-1] + 1)
        // The final value in the bottom-right corner of the 2D array will be the minimum number of operations required
        // to convert the entire first string into the entire second string
        // (i.e., the Levenshtein distance between the two strings)
        // Time complexity: O(m*n), where m is the length of str1 and n is the length of str2
        // Space complexity: O(m*n)
        // Reference: https://en.wikipedia.org/wiki/Levenshtein_distance
        // Reference: https://www.geeksforgeeks.org/edit-distance-dp-5/
        // Reference: https://leetcode.com/problems/edit-distance/
        // Reference: https://www.youtube.com/watch?v=We3YDTzNXEk
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1]; // No operation required
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])); // Insert, delete, or replace
                }
            }
        }

        //[0, 1, 2, 3, 4, 5, 6, 7] k&s - increment
        //[1, 1, 2, 3, 4, 5, 6, 7] i - stay same
        //[2, 2, 1, 2, 3, 4, 5, 6] t - stay same
        //[3, 3, 2, 1, 2, 3, 4, 5] t - stay same
        //[4, 4, 3, 2, 1, 2, 3, 4] e&i - increment
        //[5, 5, 4, 3, 2, 2, 3, 4] n&n - stay same
        //[6, 6, 5, 4, 3, 3, 2, 3] &g - increment
        return dp[m][n];
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        String str1 = "kitten";
        String str2 = "sitting";
        System.out.println("Edit distance between \"" + str1 + "\" and \"" + str2 + "\": " + editDistance.calculateEditDistance(str1, str2)); // Output: 3
    }
}
