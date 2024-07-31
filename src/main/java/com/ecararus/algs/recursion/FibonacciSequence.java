package com.ecararus.algs.recursion;

/**
 * Fibonacci Sequence: Computes the n-th Fibonacci number using recursion.
 *
 * Plan:
 * Define the FibonacciSequence class.
 * Implement the fibonacci method to calculate the n-th Fibonacci number.
 * The base case is when n is 0 or 1, in which case the Fibonacci number is n.
 * The recursive case is when n is greater than 1, in which case the Fibonacci number is the sum of the previous two Fibonacci numbers.
 */
public class FibonacciSequence {

    public int fibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        FibonacciSequence fibSeq = new FibonacciSequence();
        System.out.println("Fibonacci of 5: " + fibSeq.fibonacci(7)); // Output: 5
    }

}
