package com.ecararus.algs.sorting;

/**
 * Insertion Sort: Builds the final sorted array one item at a time,
 * inserting each new item into its proper place.
 *
 * Plan:
 * Define the InsertionSort class.
 * Implement the insertionSort method to sort an array of integers.
 * Iterate through the array, starting from the second element.
 * Compare the current element with the elements to its left and insert it into the correct position.
 * Continue iterating until the entire array is sorted.
 *
 */
public class InsertionSort {

    public void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            // Move elements of arr[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        InsertionSort sorter = new InsertionSort();
        int[] arr = {12, 11, 13, 5, 6};
        sorter.insertionSort(arr);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
