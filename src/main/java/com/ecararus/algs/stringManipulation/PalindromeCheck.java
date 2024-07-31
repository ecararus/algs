package com.ecararus.algs.stringManipulation;

/**
 * Palindrome Check: Checks if a string reads the same forwards and backwards.
 *
 * Plan:
 * Define the PalindromeCheck class.
 * Implement the isPalindrome method to check if a string is a palindrome.
 * Use two pointers, one starting from the beginning of the string and the other starting from the end.
 * Compare the characters at the two pointers and move them towards the center until they meet.
 * If the characters at the two pointers ever differ, return false.
 *
 */
public class PalindromeCheck {

    public boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeCheck checker = new PalindromeCheck();
        String testStr = "racecar";
        System.out.println("Is \"" + testStr + "\" a palindrome? " + checker.isPalindrome(testStr)); // Output: true
    }

}
