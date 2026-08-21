package patterns.hashing;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {
    /*
     * Problem : Contains Duplicate II
     * LeetCode : #219
     * Link: https://leetcode.com/problems/contains-duplicate-ii/
     * Pattern : Hashing
     * Difficulty : Easy
     * Date Solved: 18-08-2026
     * Revision : [✅] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * I used a HashMap to store the most recent index of every number.
     *
     * While traversing the array:
     * - If the current number already exists in the map, I get its previous index.
     * - If the distance between the current index and previous index is <= k,
     * then a nearby duplicate exists, so I return true.
     * - Otherwise, I update the number's index with the current index.
     *
     * Important:
     * I only need to store the most recent index of each number.
     * If the most recent occurrence is more than k positions away, then
     * every older occurrence is also more than k positions away.
     *
     * Optimal Approach:
     * A HashMap is sufficient because we need to remember the latest index
     * at which each number appeared.
     *
     * We can avoid Math.abs() because we traverse from left to right.
     * Therefore, the current index i is always greater than the previous index.
     *
     * Instead of:
     * Math.abs(previousIndex - i) <= k
     *
     * we can simply use:
     * i - previousIndex <= k
     *
     * Pattern Insight:
     * This is a Hashing problem because:
     * - We need fast lookup of previously seen numbers.
     * - We need to remember the index of each number.
     * - HashMap provides O(1) average lookup and insertion.
     *
     * Trigger:
     * "Find duplicate elements within k distance"
     * → Think: HashMap + index tracking
     *
     * Mistake I Made:
     * - Initially used containsKey() followed by get(), causing two lookups.
     * - Used Math.abs(), even though the array is traversed from left to right.
     * - A cleaner approach is to directly get the previous index and calculate
     * i - previousIndex.
     *
     * Time Complexity: O(n) average
     * Space Complexity: O(n)
     */

    // Given an integer array nums and an integer k, return true if there are
    // two distinct indices i and j such that nums[i] == nums[j] and
    // abs(i - j) <= k.
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            Integer previousIndex = map.get(nums[i]);

            if (previousIndex != null && i - previousIndex <= k) {
                return true;
            }

            map.put(nums[i], i);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        int k = 3;

        System.out.println(
                "Contains nearby duplicate: "
                        + containsNearbyDuplicate(nums, k));
    }
}