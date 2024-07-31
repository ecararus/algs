package com.ecararus.algs.sorting;

/**
 * Bubble Sort: Compares adjacent elements and swaps them if they are in the wrong order.
 * Simple but inefficient for large datasets.
 *
 * Plan:
 * Define the BubbleSort class.
 * Implement the bubbleSort method to sort an array of integers.
 * Use nested loops to iterate through the array and swap elements if they are in the wrong order.
 * Continue iterating until no swaps are needed, indicating the array is sorted.
 */
public class BubbleSort {

    public void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no two elements were swapped by inner loop, then break
            if (!swapped) break;
        }
    }

    public static void main(String[] args) {
        BubbleSort sorter = new BubbleSort();
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sorter.bubbleSort(arr);
        System.out.println("Sorted array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
