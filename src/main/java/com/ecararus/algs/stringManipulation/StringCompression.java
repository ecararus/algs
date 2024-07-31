package com.ecararus.algs.stringManipulation;

/**
 * Compress a string using counts of repeated characters.
 *
 * Plan:
 * 1. Create a StringBuilder to store the compressed string.
 * 2. Iterate through the string and keep track of the count of repeated characters.
 * 3. Append the character and count to the StringBuilder.
 * 4. If the compressed string is longer than the original string, return the original string.
 * 5. Otherwise, return the compressed string.
 */
public class StringCompression {

    // Complexity Analysis
    // This algorithm has a time complexity of O(n) where n is the length of the input string.
    // The space complexity is also O(n) because we are using a StringBuilder to store the compressed string.
    public String compressString(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        // Iterate through the string and keep track of the count of repeated characters
        // Append the character and count to the StringBuilder
        // If the compressed string is longer than the original string, return the original string
        // Otherwise, return the compressed string
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(str.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        compressed.append(str.charAt(str.length() - 1)).append(count);

        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    public static void main(String[] args) {
        StringCompression compressor = new StringCompression();
        String testStr = "aabcccccaaa";
        System.out.println("Compressed string: " + compressor.compressString(testStr)); // Output: "a2b1c5a3"
    }

}
