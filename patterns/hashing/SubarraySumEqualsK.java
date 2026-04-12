package patterns.hashing;

import java.util.HashMap;

public class SubarraySumEqualsK {
    /*
     * Problem : Subarray Sum Equals K
     * LeetCode : 560
     * Link: https://leetcode.com/problems/subarray-sum-equals-k/
     * Pattern : Prefix Sum + HashMap
     * Difficulty : Medium
     * Date Solved: 12-04-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used a running prefix sum and a HashMap to store frequencies
     * of prefix sums seen so far.
     * For each index, checked if (currentSum - k) exists in map.
     * If yes, it means a subarray with sum = k exists.
     *
     * Pattern Insight:
     * Prefix sum transforms subarray problems into lookup problems.
     * Key idea: sum(i, j) = prefix[j] - prefix[i-1]
     * So we look for (currentSum - k).
     *
     * Mistake I Made:
     * Initially tried brute force (checking all subarrays → O(n²)).
     * Also forgot to initialize map with (0 → 1),
     * which is needed to count subarrays starting from index 0.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    // Given an array of integers nums and an integer k, return the total number of
    // subarrays whose sum equals to k. A subarray is a contiguous non-empty
    // sequence of elements within an array.
    public static int subarraySum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int curr = 0;

        for (int el : arr) {
            curr += el;
            sum += map.getOrDefault(curr - k, 0);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        System.err.println("total number of subarrays whose sum equals to k are: " + subarraySum(arr, 3));
    }
}