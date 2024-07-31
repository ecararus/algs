package com.ecararus.algs.arrayManipulation;

/**
 * Reversing an Array: Swaps elements from the beginning and end of the array moving towards the center.
 *
 * Plan:
 * Define the ArrayReversing class.
 * Implement the reverseArray method to reverse an array of integers.
 * Use two pointers, one starting from the beginning of the array and the other starting from the end.
 * Swap the elements at the two pointers and move them towards the center until they meet.
 *
 */
public class ArrayReversing {

    public void reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            // Swap the elements at left and right
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            // Move the pointers towards the center
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ArrayReversing reverser = new ArrayReversing();
        int[] arr = {1, 2, 3, 4, 5};
        reverser.reverseArray(arr);
        System.out.println("Reversed array: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
