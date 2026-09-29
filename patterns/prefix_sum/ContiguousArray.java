package patterns.prefix_sum;

import java.util.*;

public class ContiguousArray {

    /**
     * Problem : Contiguous Array
     * LeetCode : #525
     * Link: https://leetcode.com/problems/contiguous-array/
     * Pattern : Prefix Sum
     * Difficulty : Medium
     * Date Solved: 29-Sep-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Treat 0 as -1 and 1 as +1.
     *
     * Then the problem becomes finding the longest subarray
     * whose sum is 0.
     *
     * If the same prefix sum appears at two different indices,
     * the elements between those indices have a sum of 0.
     *
     * This means that subarray contains equal number of 0s and 1s.
     *
     * Optimal Approach:
     * Use a HashMap to store the first index where each prefix sum occurs.
     *
     * Initialize:
     * map.put(0, -1)
     *
     * This handles subarrays starting from index 0.
     *
     * For every element:
     *
     * 0 -> -1
     * 1 -> +1
     *
     * If the current prefix sum already exists in the map:
     * currentIndex - firstIndex
     * gives the length of a valid subarray.
     *
     * We store only the FIRST occurrence of each prefix sum
     * because it gives the longest possible subarray.
     *
     * Pattern Insight:
     * When a problem asks for the longest subarray with
     * equal number of 0s and 1s, convert:
     *
     * 0 -> -1
     * 1 -> +1
     *
     * Then use Prefix Sum + HashMap.
     *
     * Same prefix sum at two indices means the sum between
     * those indices is 0.
     *
     * Mistake I Made:
     * Tried to find the longest valid subarray by checking
     * every possible window.
     *
     * That results in O(n²) time.
     *
     * The HashMap lets us remember previous prefix sums,
     * allowing us to find valid ranges in O(1) average time.
     *
     * Time Complexity:
     * O(n)
     *
     * Space Complexity:
     * O(n)
     */

    public static int findMaxLength(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        // Prefix sum 0 exists before the array starts
        map.put(0, -1);

        int sum = 0;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            // Convert 0 -> -1 and 1 -> +1
            sum += (nums[i] == 0) ? -1 : 1;

            if (map.containsKey(sum)) {

                // Same prefix sum means sum between them is 0
                max = Math.max(max, i - map.get(sum));

            } else {

                // Store only the first occurrence
                map.put(sum, i);
            }
        }

        return max;
    }

    public static void main(String[] args) {

        System.out.println(
                findMaxLength(new int[] { 0, 1 })); // 2

        System.out.println(
                findMaxLength(new int[] { 0, 1, 0 })); // 2

        System.out.println(
                findMaxLength(new int[] { 0, 0, 1, 0, 0, 0, 1, 1 })); // 6
    }
}