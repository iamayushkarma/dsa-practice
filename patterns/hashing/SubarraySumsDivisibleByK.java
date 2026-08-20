package patterns.hashing;

import java.util.HashMap;

public class SubarraySumsDivisibleByK {

    /**
     * Problem : Subarray Sums Divisible by K
     * LeetCode : 974
     * Link: https://leetcode.com/problems/subarray-sums-divisible-by-k/
     * Pattern : Prefix Sum + Mod + HashMap
     * Difficulty : Medium
     * Date Solved: 20-08-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used running prefix sum and stored (sum % k) in a HashMap
     * with the frequency of each remainder.
     * 
     * If the same remainder appears again, it means the subarray
     * between those prefix sums has a sum divisible by k.
     *
     * Since the same remainder can appear multiple times, we store
     * its frequency and add that frequency to the count.
     *
     * Also handled negative remainders using:
     * ((sum % k) + k) % k
     *
     * Pattern Insight:
     * If (prefix[j] - prefix[i]) % k == 0,
     * then prefix[j] % k == prefix[i] % k.
     *
     * So instead of storing the complete prefix sum,
     * we only store its remainder when divided by k.
     *
     * Every previous occurrence of the same remainder forms
     * one valid subarray ending at the current index.
     *
     * Mistake I Made:
     * Initially stored only the first/last index of each remainder
     * and increased the count by 1.
     *
     * But in this problem, the same remainder can occur multiple
     * times, and every previous occurrence creates a valid subarray.
     *
     * So we need to store the frequency of each remainder.
     *
     * Also initially used sum % k directly, which can produce
     * negative remainders in Java when nums contains negative values.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(min(n, k))
     */

    // Given an integer array nums and an integer k, return the number
    // of non-empty subarrays that have a sum divisible by k.
    //
    // A subarray is a contiguous part of the array.
    //
    // If two prefix sums have the same remainder when divided by k,
    // their difference is divisible by k.

    public static int subarraysDivByK(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Remainder 0 exists once before processing the array.
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            // Normalize negative remainders.
            int mod = ((sum % k) + k) % k;

            // Every previous occurrence of this remainder
            // forms one valid subarray.
            if (map.containsKey(mod)) {
                count += map.get(mod);
            }

            // Increase frequency of this remainder.
            map.put(mod, map.getOrDefault(mod, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {

        int[] arr = { 4, 5, 0, -2, -3, 1 };

        System.out.println(subarraysDivByK(arr, 5));
    }
}