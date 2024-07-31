package com.ecararus.algs.search;

/**
 * Linear Search: Iterates through each element in a list to find the target value.
 * Simple but can be slow for large lists.
 *
 * Plan:
 * Define the LinearSearch class.
 * Implement the linearSearch method to search for a target value in a list.
 * Iterate through each element in the list and return the index if the target value is found.
 * If the target value is not found, return -1.
 */
public class LinearSearch {

    public int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LinearSearch search = new LinearSearch();
        int[] arr = {1, 2, 3, 4, 5};
        int target = 3;
        int result = search.linearSearch(arr, target);
        System.out.println("Index of target " + target + ": " + result); // Output: 2
    }
}
