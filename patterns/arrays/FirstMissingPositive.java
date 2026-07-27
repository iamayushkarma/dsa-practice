package patterns.arrays;

public class FirstMissingPositive {
    /*
     * Problem : First Missing Positive
     * LeetCode : 41
     * Link: https://leetcode.com/problems/first-missing-positive/
     * Pattern : Array Marking (Index as Hash)
     * Difficulty : Hard
     * Date Solved: 27-07-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * I knew that the answer would always lie between 1 and n+1, but I couldn't
     * figure out how to track the presence of numbers without using extra space.
     * After understanding the optimal solution, I learned that the array itself
     * can be used as a hash map by marking indices as negative.
     *
     * Optimal Approach:
     * 1. Replace all invalid numbers (<= 0 or > n) with n + 1 since they cannot
     * affect the answer.
     * 2. Traverse the array again. For every valid number x, mark its corresponding
     * index (x - 1) as negative to indicate that x exists.
     * 3. Traverse the array one last time. The first positive index i means
     * the number (i + 1) is missing.
     * 4. If every index is marked negative, then all numbers from 1 to n exist,
     * so return n + 1.
     *
     * Pattern Insight:
     * Array Marking (Index as Hash)
     * Range Observation
     * In-place Hashing
     *
     * Mistake I Made:
     * I was thinking about using extra space like a HashSet instead of realizing
     * that the input array itself can be used for marking visited numbers.
     * I also missed the important observation that the answer is always in the
     * range [1, n + 1].
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    // Given an unsorted integer array nums, return the smallest missing positive
    // integer. The algorithm must run in O(n) time and use O(1) extra space.
    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;

        // Step 1: Ignore invalid numbers
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }

        // Step 2: Mark existing numbers
        for (int i = 0; i < n; i++) {
            int el = Math.abs(nums[i]);

            if (el == n + 1)
                continue;

            int seat = el - 1;
            if (nums[seat] > 0) {
                nums[seat] *= -1;
            }
        }

        // Step 3: Find first missing positive
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }

        return n + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 3, 4, -1, 1 };
        System.out.println("First missing positive is: " + firstMissingPositive(arr));
    }
}