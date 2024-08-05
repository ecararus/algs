package com.ecararus.algs.aws;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Code Question 1
 * New Year's Day is around the corner and Amazon is having a sale.
 * They have a list of items they are considering but they may need to remove some of them.
 * Determine the minimum number of items to remove from an array of prices so that the sum of prices of any k items does not exceed a threshold.
 * Note: If the number of items in the list is less than k, then there is no need to remove any more items.
 *
 * Example
 * prices = [3, 2, 1, 4, 6, 51
 * k = 3
 * threshold = 14
 * $3
 * $2
 * $1
 * $4
 * $6
 * $5
 * The sum of prices for every k= 3 items must not be more than threshold
 * = 14. The sum of the prices of the last three items is 6 + 5 + 4 = 15. The
 * item priced $6 can be removed leaving:
 * $3
 * $2
 * $1
 * $5
 * No 3 items' prices sum to greater than 14. Only 1 item needs to be removed.
 *
 * Function Description
 * Complete the function reduceGifts in the editor below.
 * reduceGifts has the following parameters: int pricesin]: the prices of each item int k: the number of items to sum int threshold: the maximum price of k items
 *
 * Returns
 * int: the minimum number of items to remove from the list
 *
 */
public class AmazonSale {

    public static int reduceGifts(int[] prices, int k, int threshold) {
        Arrays.sort(prices);
        int n = prices.length;
        int itemsRemoved = 0;

        while (true) {
            boolean valid = true;
            for (int i = 0; i <= n - k; i++) {
                int sum = 0;
                for (int j = 0; j < k; j++) {
                    sum += prices[i + j];
                }
                if (sum > threshold) {
                    valid = false;
                    break;
                }
            }
            if (valid) {
                break;
            }
            prices = Arrays.copyOf(prices, n - 1);
            n--;
            itemsRemoved++;
        }

        return itemsRemoved;
    }

    public static void main(String[] args) {
        int[] prices = {3, 2, 1, 4, 6, 5, 6};
        int k = 3;
        int threshold = 14;
        System.out.println(reduceGifts(prices, k, threshold)); // Output: 1
    }
}