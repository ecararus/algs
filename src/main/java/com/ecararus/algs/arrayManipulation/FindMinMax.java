package com.ecararus.algs.arrayManipulation;

/**
 * Finding Maximum/Minimum: Iterates through the array to find the maximum or minimum value.
 *
 * Plan:
 * Define the FindMinMax class.
 *  Implement the findMax method to find the maximum value in an array of integers.
 *  Initialize a variable max to the smallest possible integer value.
 *  Iterate through the array and update max if a larger value is found.
 *  Return the maximum value.
 *
 */
public class FindMinMax {

    public int[] findMaxMin(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : arr) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        return new int[]{max, min};
    }

    public static void main(String[] args) {
        FindMinMax finder = new FindMinMax();
        int[] arr = {1, 2, 3, 4, 5};
        int[] result = finder.findMaxMin(arr);
        System.out.println("Maximum value: " + result[0]); // Output: 5
        System.out.println("Minimum value: " + result[1]); // Output: 1
    }
}
