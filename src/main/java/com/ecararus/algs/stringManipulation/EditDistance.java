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

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        String str1 = "kitten";
        String str2 = "sitting";
        System.out.println("Edit distance between \"" + str1 + "\" and \"" + str2 + "\": " + editDistance.calculateEditDistance(str1, str2)); // Output: 3
    }
}
