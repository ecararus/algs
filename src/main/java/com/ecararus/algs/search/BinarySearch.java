package com.ecararus.algs.search;

/**
 * Binary Search: Efficiently finds a target value in a sorted list by repeatedly dividing the search interval in half.
 *
 * Plan:
 * Define the BinarySearch class.
 * Implement the binarySearch method to search for a target value in a sorted list.
 * Initialize low and high pointers to the start and end of the list.
 * While low is less than or equal to high, calculate the mid index.
 * If the target value is equal to the mid value, return the mid index.
 * If the target value is less than the mid value, update the high pointer to mid - 1.
 * If the target value is greater than the mid value, update the low pointer to mid + 1.
 * If the target value is not found, return -1.
 */
public class BinarySearch {

    public int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        int[] arr = {1, 2, 3, 4, 5};
        int target = 3;
        int result = search.binarySearch(arr, target);
        System.out.println("Index of target " + target + ": " + result); // Output: 2
    }

}
