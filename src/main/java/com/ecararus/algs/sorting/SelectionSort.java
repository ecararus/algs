package com.ecararus.algs.sorting;

/**
 * Selection Sort:
 * Selects the smallest element from an unsorted list and swaps it with the first unsorted element.
 *
 * Plan:
 * Define the SelectionSort class.
 * Implement the selectionSort method to sort an array of integers.
 * Use nested loops to iterate through the array and find the smallest element in the unsorted portion.
 * Swap the smallest element with the first unsorted element.
 * Continue iterating until the entire array is sorted.
 *
 */
public class SelectionSort {

    public void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted portion
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first unsorted element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        SelectionSort sorter = new SelectionSort();
        int[] arr = {64, 25, 12, 22, 11};
        sorter.selectionSort(arr);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
