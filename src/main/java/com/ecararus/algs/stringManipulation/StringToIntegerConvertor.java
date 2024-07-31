package com.ecararus.algs.stringManipulation;

/**
 * Convert a string representation of a number to an integer (e.g., implementing atoi)
 *
 * Plan:
 * 1. Trim the string
 * 2. Check if the string is empty
 * 3. Check if the string starts with a sign
 * 4. Check if the string starts with a digit
 * 5. Check if the string starts with a non-digit character
 * 6. Check if the string starts with a digit and a non-digit character
 * 7. Check if the string starts with a non-digit character and a digit
 * 8. Check if the string starts with a non-digit character and a non-digit character
 * 9. Check if the string starts with a digit and a digit
 * 10. Check if the string starts with a sign and a non-digit character
 * 11. Check if the string starts with a sign and a digit
 * 12. Check if the string starts with a sign and a sign
 */
public class StringToIntegerConvertor {

    public int convertStringToInteger(String str) {
        if (str == null || str.trim().isEmpty()) {
            return 0;
        }

        str = str.trim();
        int length = str.length();
        int index = 0;
        int sign = 1;
        int result = 0;

        // Check for sign
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = (str.charAt(index) == '-') ? -1 : 1;
            index++;
        }

        // Convert characters to integer
        while (index < length) {
            char c = str.charAt(index);
            if (c < '0' || c > '9') {
                break;
            }

            // Check for overflow and underflow
            if (result > (Integer.MAX_VALUE - (c - '0')) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + (c - '0');
            index++;
        }

        return result * sign;
    }

    public static void main(String[] args) {
        StringToIntegerConvertor convertor = new StringToIntegerConvertor();
        System.out.println(convertor.convertStringToInteger("42")); // Output: 42
        System.out.println(convertor.convertStringToInteger("   -42")); // Output: -42
        System.out.println(convertor.convertStringToInteger("4193 with words")); // Output: 4193
        System.out.println(convertor.convertStringToInteger("words and 987")); // Output: 0
        System.out.println(convertor.convertStringToInteger("-91283472332")); // Output: -2147483648 (Integer.MIN_VALUE)
    }
}
