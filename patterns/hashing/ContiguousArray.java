package patterns.hashing;

import java.util.*;

public class ContiguousArray {
    /*
     * Problem : Contiguous Array
     * LeetCode : 525
     * Link: https://leetcode.com/problems/contiguous-array/
     * Pattern : Prefix Sum + HashMap
     * Difficulty : Medium
     * Date Solved: 12-04-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Converted 0 → -1 and kept 1 as +1.
     * Used running prefix sum and stored sum in a HashMap
     * with its first occurrence index.
     * If the same sum appears again, it means the subarray
     * between those indices has equal number of 0s and 1s.
     * Tracked maximum length of such subarrays.
     *
     * Pattern Insight:
     * Equal number of 0s and 1s ⇒ net sum = 0.
     * If prefix[j] == prefix[i], then subarray (i+1 → j) has sum 0.
     * So we store prefix sums and look for repeats.
     *
     * Mistake I Made:
     * Initially tried counting 0s and 1s separately for every subarray (O(n²)).
     * Also missed converting 0 → -1, which simplifies the problem to sum = 0.
     * Forgot to store first occurrence of sum, which is needed for max length.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    // Given a binary array nums, return the maximum length of a contiguous subarray
    // with an equal number of 0 and 1.

    public static int findMaxLength(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                sum += -1;
            else
                sum += +1;

            if (map.containsKey(sum)) {
                int len = i - map.get(sum);
                maxLen = Math.max(maxLen, len);
            } else
                map.put(sum, i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 1, 1, 1, 1, 0, 0, 0 };
        System.err.println(
                "maximum length of a contiguous subarray with an equal number of 0 and 1 are: " + findMaxLength(arr));
    }
}
