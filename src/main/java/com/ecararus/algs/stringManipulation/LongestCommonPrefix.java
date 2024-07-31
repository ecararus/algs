package com.ecararus.algs.stringManipulation;

/**
 * Find the longest common prefix among a set of strings.
 *
 * Plan:
 * 1. Find the shortest string in the set.
 * 2. Compare the shortest string with the rest of the strings in the set.
 * 3. If the shortest string is a prefix of the rest of the strings, return the shortest string.
 * 4. If the shortest string is not a prefix of the rest of the strings, remove the last character of the shortest string and repeat step 3.
 * 5. If the shortest string is empty, return an empty string.
 *
 */
public class LongestCommonPrefix {

    public String findLongestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String shortest = strs[0];
        for (String str : strs) {
            if (str.length() < shortest.length()) {
                shortest = str;
            }
        }

        // Compare the shortest string with the rest of the strings
        // If the shortest string is not a prefix of the rest of the strings, remove the last character of the shortest string
        // Repeat the process until the shortest string is a prefix of the rest of the strings
        // If the shortest string is empty, return an empty string
        for (int i = 0; i < shortest.length(); i++) {
            char c = shortest.charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != c) {
                    return shortest.substring(0, i);
                }
            }
        }

        return shortest;
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Longest common prefix: " + lcp.findLongestCommonPrefix(strs)); // Output: "fl"
    }

}
