package patterns.hashing;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    /*
     * Problem : 4Sum II
     * LeetCode : #454
     * Link: https://leetcode.com/problems/4sum-ii/
     * Pattern : Hashing
     * Difficulty : Medium
     * Date Solved: 19-08-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * I used a HashMap to store the frequency of every possible sum
     * formed by nums1 and nums2.
     *
     * While traversing nums1 and nums2:
     * - Calculate nums1[i] + nums2[j].
     * - Store its frequency in the HashMap.
     *
     * Then I traverse nums3 and nums4:
     * - Calculate nums3[k] + nums4[l].
     * - Find its complement:
     *   0 - (nums3[k] + nums4[l])
     * - If the complement exists in the map, add its frequency to totalCount.
     *
     * This works because:
     * nums1[i] + nums2[j] + nums3[k] + nums4[l] = 0
     *
     * Therefore:
     * nums1[i] + nums2[j] = -(nums3[k] + nums4[l])
     *
     * Important:
     * We store frequencies instead of just checking whether a sum exists.
     * The same sum can be formed by multiple pairs, and every matching pair
     * contributes to the final answer.
     *
     * Optimal Approach:
     * Instead of trying all four arrays together, which would take O(n^4),
     * divide the problem into two pairs:
     *
     * (nums1 + nums2) and (nums3 + nums4)
     *
     * Store all sums from the first pair in a HashMap and then look for
     * their complements from the second pair.
     *
     * Pattern Insight:
     * This is a Hashing problem because:
     * - We need to quickly find whether a required complement exists.
     * - Multiple pairs can produce the same sum.
     * - HashMap provides O(1) average lookup and insertion.
     *
     * Trigger:
     * "Find the number of combinations whose sum is 0"
     * with 4 arrays
     * → Think: Split into two pairs + HashMap frequency
     *
     * Mistake I Made:
     * - Trying to consider all four arrays at the same time would result
     *   in O(n^4) time.
     * - The key optimization is to split the four arrays into two groups.
     * - We must store the frequency of each sum, not just the sum itself,
     *   because duplicate sums represent multiple valid combinations.
     *
     * Time Complexity: O(n²) average
     * Space Complexity: O(n²)
     */

    // Given four integer arrays nums1, nums2, nums3, and nums4 of length n,
    // return the number of tuples (i, j, k, l) such that:
    // nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0.
    public static int fourSumCount(
            int[] nums1,
            int[] nums2,
            int[] nums3,
            int[] nums4) {

        int n = nums1.length;
        int totalCount = 0;

        Map<Integer, Integer> map = new HashMap<>();

        // Store frequency of all sums from nums1 + nums2
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums1[i] + nums2[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        // Find complements from nums3 + nums4
        for (int k = 0; k < n; k++) {
            for (int l = 0; l < n; l++) {
                int complement = 0 - (nums3[k] + nums4[l]);
                totalCount += map.getOrDefault(complement, 0);
            }
        }

        return totalCount;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { -2, -1 };
        int[] nums3 = { -1, 2 };
        int[] nums4 = { 0, 2 };

        System.out.println(
                "Four sum count: "
                        + fourSumCount(nums1, nums2, nums3, nums4));
    }
}