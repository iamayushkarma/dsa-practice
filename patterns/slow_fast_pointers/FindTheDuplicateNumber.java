package patterns.slow_fast_pointers;

public class FindTheDuplicateNumber {

    /*
     * Problem : Find the Duplicate Number
     * LeetCode : #287
     * Link: https://leetcode.com/problems/find-the-duplicate-number/
     * Pattern : Floyd's Cycle Detection (Fast & Slow Pointers)
     * Difficulty : Medium
     * Date Solved: 14-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Treat each array element as a pointer to another index.
     * Use slow and fast pointers to detect a cycle.
     * Once they meet, reset the slow pointer to nums[0].
     * Move both pointers one step at a time until they meet again.
     * The meeting value is the duplicate number.
     *
     * Optimal Approach:
     * Floyd's Tortoise and Hare algorithm detects the cycle
     * and identifies its entrance without modifying the array.
     *
     * Pattern Insight:
     * Since the array contains n + 1 elements and every value
     * belongs to the range [1, n], a cycle must exist.
     *
     * The duplicate number corresponds to the cycle entrance.
     *
     * Mistake I Made:
     * 1. Initially used while(temp1 != temp2) with both pointers
     * starting at the same position, so the loop never executed.
     * 2. Initially used temp1 instead of temp2 when moving
     * the fast pointer two steps.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    /*
     * Problem Statement:
     * Given an integer array nums containing n + 1 integers,
     * where each integer is in the range [1, n] inclusive,
     * return the only number that appears more than once.
     *
     * The duplicate number may appear multiple times.
     * Do not modify the array and use only constant extra space.
     */

    public static int findDuplicate(int[] nums) {
        int temp1 = nums[0];
        int temp2 = nums[0];

        // Phase 1: Find the meeting point
        while (true) {
            temp1 = nums[temp1];
            temp2 = nums[nums[temp2]];

            if (temp1 == temp2)
                break;
        }

        // Phase 2: Find the cycle entrance
        temp1 = nums[0];

        while (temp1 != temp2) {
            temp1 = nums[temp1];
            temp2 = nums[temp2];
        }

        return temp1;
    }

    public static void main(String[] args) {

        // Test Case 1
        int[] nums1 = { 1, 3, 4, 2, 2 };
        assert findDuplicate(nums1) == 2;

        // Test Case 2
        int[] nums2 = { 3, 1, 3, 4, 2 };
        assert findDuplicate(nums2) == 3;

        // Test Case 3: All elements are identical
        int[] nums3 = { 3, 3, 3, 3, 3 };
        assert findDuplicate(nums3) == 3;

        // Test Case 4
        int[] nums4 = { 1, 1 };
        assert findDuplicate(nums4) == 1;

        // Test Case 5
        int[] nums5 = { 2, 2, 2, 2, 2 };
        assert findDuplicate(nums5) == 2;

        System.out.println("All test cases passed!");
    }
}