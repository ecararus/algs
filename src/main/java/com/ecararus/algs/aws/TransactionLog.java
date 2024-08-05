package com.ecararus.algs.aws;

import java.util.*;

/**
 * Amazon Transaction Logs (example question)
 * Your Amazonian team is responsible for maintaining a monetary transaction service. The transactions are tracked in a log file.
 * A log file is provided as a string array where each entry represents a transaction to service. Each transaction consists of:
 * • sender_user_id: Unique identifier for the user that initiated the transaction.
 * It consists of only digits with at most 9 digits.
 * • recipient_user_id: Unique identifier for the user that is receiving the transaction. It consists of only digits with at most 9 digits.
 * • amount_of_transaction: The amount of the transaction. It consists of only digits with at most 9 digits.
 * The values are separated by a space. For example, "sender_user_id recipient_user_id amount_of_transaction".
 * Users that perform an excessive amount of transactions might be abusing the service so you have been tasked to identify the users that have a number of transactions over a threshold. The list of user ids should be ordered in ascending numeric value.
 *
 * Example
 * logs = ["88 99 200", "88 99 300", "99 32 100", " 12 12 15"]
 * threshold = 2
 * The transactions count for each user, regardless of role are:
 * ID
 * - -
 * 99
 * 88
 * 12
 * 32
 *
 * Transactions
 * 3
 * 2
 * 1
 * 1
 * There are two users with at least threshold = 2 transactions: 99 and 88. In
 * ascending order, the return array is ['88', '99'].
 *
 * Note: In the last log entry, user 12 was on both sides of the transaction.
 * This counts as only 1 transaction for user 12.
 * Function Description
 * Complete the function processLogs in the editor below.
 * The function has the following parameters):
 * string logs[n]: each logs[i] denotes the ith entry in the logs int threshold: the minimum number of transactions that a user must
 * have to be included in the result
 *
 */
public class TransactionLog {

    public static List<String> getUsersOverThreshold(String[] logs, int threshold) {
        Map<String, Integer> transactionCount = new HashMap<>();

        // Parse logs and count transactions
        for (String log : logs) {
            String[] parts = log.trim().split(" ");
            String sender = parts[0];
            String recipient = parts[1];

            transactionCount.put(sender, transactionCount.getOrDefault(sender, 0) + 1);
            if(!sender.equals(recipient)) {
                transactionCount.put(recipient, transactionCount.getOrDefault(recipient, 0) + 1);
            }
        }

        // Filter users by threshold
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : transactionCount.entrySet()) {
            if (entry.getValue() >= threshold) {
                result.add(entry.getKey());
            }
        }

        // Sort user IDs in ascending numeric order
        Collections.sort(result, (a, b) -> Long.compare(Long.parseLong(a), Long.parseLong(b)));

        return result;
    }

    public static void main(String[] args) {
        String[] logs = {"88 99 200", "88 99 300", "99 32 100", "12 12 15"};
        int threshold = 2;
        System.out.println(getUsersOverThreshold(logs, threshold)); // Output: [88, 99]
    }
}
