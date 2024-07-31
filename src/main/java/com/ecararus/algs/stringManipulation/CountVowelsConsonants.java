package com.ecararus.algs.stringManipulation;

/**
 * Count the number of vowels and consonants in a string.
 *
 * Plan:
 * 1. Create a method that takes a string as input.
 * 2. Create a counter for vowels and consonants.
 * 3. Loop through the string and check if the character is a vowel or consonant.
 * 4. Increment the counter accordingly.
 * 5. Return the count of vowels and consonants.
 */
public class CountVowelsConsonants {

    public int[] countVowelsAndConsonants(String str) {
        int vowels = 0;
        int consonants = 0;
        String vowelsList = "aeiouAEIOU";

        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) {
                if (vowelsList.indexOf(c) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        return new int[]{vowels, consonants};
    }

    public static void main(String[] args) {
        CountVowelsConsonants counter = new CountVowelsConsonants();
        String testStr = "hello world";
        int[] counts = counter.countVowelsAndConsonants(testStr);
        System.out.println("Vowels: " + counts[0] + ", Consonants: " + counts[1]); // Output: Vowels: 3, Consonants: 7
    }
}
