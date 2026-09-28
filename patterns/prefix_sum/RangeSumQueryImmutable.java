package patterns.prefix_sum;

public class RangeSumQueryImmutable {

    /*
     * Problem : Range Sum Query - Immutable
     * LeetCode : #303
     * Link: https://leetcode.com/problems/range-sum-query-immutable/
     * Pattern : Prefix Sum
     * Difficulty : Easy
     * Date Solved: 28-Sep-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Store the prefix sum of the array.
     *
     * prefix[i + 1] represents the sum of the first i + 1 elements.
     *
     * For a range from left to right:
     *
     * prefix[right + 1] - prefix[left]
     *
     * gives the sum of elements from left to right.
     *
     * Optimal Approach:
     * Build the prefix sum array once in the constructor.
     *
     * Each sumRange() query can then be answered in O(1).
     *
     * Pattern Insight:
     * When we have multiple range-sum queries on an array
     * that does not change, use Prefix Sum.
     *
     * Instead of calculating the sum again for every query,
     * calculate cumulative sums once and reuse them.
     *
     * Mistake I Made:
     * Tried to calculate the sum using a loop inside sumRange().
     *
     * This works but takes O(n) for every query.
     *
     * Also, nums and sum were declared inside the constructor,
     * so they could not be accessed inside sumRange().
     *
     * Time Complexity:
     * Constructor: O(n)
     * sumRange(): O(1)
     *
     * Space Complexity: O(n)
     */

    static class NumArray {

        int[] prefix;

        public NumArray(int[] nums) {

            int n = nums.length;

            prefix = new int[n + 1];

            for (int i = 0; i < n; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {

            return prefix[right + 1] - prefix[left];
        }
    }

    public static void main(String[] args) {

        NumArray obj = new NumArray(new int[] { -2, 0, 3, -5, 2, -1 });

        System.out.println(obj.sumRange(0, 2)); // 1
        System.out.println(obj.sumRange(2, 5)); // -1
        System.out.println(obj.sumRange(0, 5)); // -3
    }
}
