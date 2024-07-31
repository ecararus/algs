package com.ecararus.algs.recursion;

/**
 * Factorial Calculation: Computes the factorial of a number using recursive calls.
 *
 * Plan:
 * Define the FactorialCalculation class.
 * Implement the factorial method to calculate the factorial of a number.
 * The base case is when n is 0 or 1, in which case the factorial is 1.
 * The recursive case is when n is greater than 1, in which case the factorial is n times the factorial of n - 1.
 *
 */
public class FactorialCalculation {

    public int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static void main(String[] args) {
        FactorialCalculation calc = new FactorialCalculation();
        System.out.println("Factorial of 5: " + calc.factorial(5)); // Output: 120
    }

}
