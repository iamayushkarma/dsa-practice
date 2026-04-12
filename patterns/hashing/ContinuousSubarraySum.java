package patterns.hashing;

import java.util.HashMap;

public class ContinuousSubarraySum {
    /*
     * Problem : Continuous Subarray Sum
     * LeetCode : 523
     * Link: https://leetcode.com/problems/continuous-subarray-sum/
     * Pattern : Prefix Sum + Mod + HashMap
     * Difficulty : Medium
     * Date Solved: 12-04-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used running prefix sum and stored (sum % k) in a HashMap
     * with its first occurrence index.
     * If same remainder appears again, it means the subarray
     * between those indices has sum divisible by k.
     * Also ensured subarray length >= 2.
     *
     * Pattern Insight:
     * If (prefix[j] - prefix[i]) % k == 0,
     * then prefix[j] % k == prefix[i] % k.
     * So we track remainders instead of full sums.
     *
     * Mistake I Made:
     * Initially tried checking only prefix sums,
     * which misses subarrays in between.
     * Also missed storing index and length condition (>=2).
     *
     * Time Complexity: O(n)
     * Space Complexity: O(min(n, k))
     */

    // Given an integer array `nums` and an integer `k`, determine whether the array
    // contains a **good subarray**. A good subarray is a contiguous part of the
    // array that has a length of at least two and whose sum is a multiple of `k`.
    // In other words, the total sum of that subarray should be equal to `n × k` for
    // some integer `n`. It’s important to note that a subarray must consist of
    // consecutive elements, and that **0 is always considered a multiple of `k`**,
    // since `0 = 0 × k`.

    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int mod = sum % k;
            if (map.containsKey(mod)) {
                if (i - map.get(mod) > 1) {
                    return true;
                }
            } else {
                map.put(mod, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 23, 2, 4, 6, 7 };
        System.out.println(checkSubarraySum(arr, 6));
    }
}
