package com.ecararus.algs.stringManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate all permutations of a string.
 *
 * Plan:
 * 1. Create a method that takes a string as input.
 * 2. Create a recursive helper method that generates all permutations.
 * 3. Swap characters in the string to generate all permutations.
 * 4. Return the list of permutations.
 */
public class StringPermutations {

    public List<String> generatePermutations(String str) {
        List<String> result = new ArrayList<>();
        permute(str.toCharArray(), 0, result);
        return result;
    }

    private void permute(char[] chars, int index, List<String> result) {
        if (index == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);//
            permute(chars, index + 1, result); // recursive call for the next index
            swap(chars, index, i); // backtrack
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        StringPermutations sp = new StringPermutations();
        String testStr = "ABC";
        List<String> permutations = sp.generatePermutations(testStr);
        System.out.println("Permutations of " + testStr + ": " + permutations);
    }
}
