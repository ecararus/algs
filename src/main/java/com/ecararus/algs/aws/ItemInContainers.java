package com.ecararus.algs.aws;

import java.util.Arrays;

/**
 * Items in Containers (example question)
 * Amazon would like to know how much inventory exists in their closed inventory compartments. Given a string s consisting of items as "*" and closed compartments as an open and close "|", an array of starting indices startindices, and an array of ending indices endindices, determine the number of items in closed compartments within the substring between the two indices, inclusive.
 * • An item is represented as an asterisk ('*' = ascii decimal 42)
 * • A compartment is represented as a pair of pipes that may or may not have items between them ('|'= ascii decimal 124).
 *
 * Example
 * 5='**|*|*
 * startindices = [1, 1]
 * endindices = [5, 6]
 * The string has a total of 2 closed compartments, one with 2 items and one with 1 item. For the first pair of indices, (1, 5), the substring is '|**|**.
 * There are 2 items in a compartment.
 * For the second pair of indices, (1, 6), the substring is '|**|*|' and there
 * are 2 + 1 = 3 items in compartments.
 * Both of the answers are returned in an array, [2, 31.
 *
 * Function Description.
 * Complete the numberOfltems function in the editor below. The function must return an integer array that contains the results for each of the startindices[i] and endindices[i] pairs.
 * numberOfltems has three parameters:
 * - 5: A string to evaluate
 * - startindices: An integer array, the starting indices.
 * - endindices: An integer array, the ending indices.
 *
 * Constraints
 * • 15m, n≤ 105
 * • 1 ≤ startindices[i] ≤ endindices/i] ≤ n
 * • Each character of sis either '*'or'!'
 */
public class ItemInContainers {


    public static int[] numberOfItems(String s, int[] startIndices, int[] endIndices) {
        int n = s.length();
        int[] prefixSum = new int[n + 1];
        int[] leftCompartment = new int[n];
        int[] rightCompartment = new int[n];
        int[] result = new int[startIndices.length];

        // Calculate prefix sums of items
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + (s.charAt(i) == '*' ? 1 : 0);
        }

        // Calculate nearest left compartment boundaries
        int lastCompartment = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                lastCompartment = i;
            }
            leftCompartment[i] = lastCompartment;
        }

        // Calculate nearest right compartment boundaries
        lastCompartment = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                lastCompartment = i;
            }
            rightCompartment[i] = lastCompartment;
        }

        // Process each query
        for (int i = 0; i < startIndices.length; i++) {
            int start = startIndices[i] - 1;
            int end = endIndices[i] - 1;

            int left = rightCompartment[start];
            int right = leftCompartment[end];

            if (left != -1 && right != -1 && left < right) {
                result[i] = prefixSum[right + 1] - prefixSum[left + 1];
            } else {
                result[i] = 0;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "**|*|*";
        int[] startIndices = {1, 1};
        int[] endIndices = {5, 6};
        System.out.println(Arrays.toString(numberOfItems(s, startIndices, endIndices))); // Output: [2, 3]
    }
}
