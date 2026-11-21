package patterns.slow_fast_pointers;

public class CircularArrayLoop {

    /*
     * Problem : Circular Array Loop
     * LeetCode : #457
     * Link: https://leetcode.com/problems/circular-array-loop/
     * Pattern : Fast & Slow Pointers / Cycle Detection
     * Difficulty : Medium
     * Date Solved: 21-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - Iterate through every index as a possible starting point.
     * - Use slow and fast pointers to detect a cycle.
     * - Ensure movement remains in the same direction.
     * - Reject cycles of length one.
     * - Mark visited elements as zero to avoid reprocessing them.
     *
     * Optimal Approach:
     * - Floyd's Cycle Detection with direction validation.
     * - Mark processed indices to avoid redundant traversal.
     *
     * Pattern Insight:
     * - Fast and slow pointers can detect cycles in an array
     * when the array is treated as a circular linked structure.
     * - Direction consistency is necessary for a valid cycle.
     * - A self-loop is not considered a valid cycle.
     *
     * Mistake I Made:
     * - Initially used incorrect index calculations for negative movement.
     * - Forgot to handle direction changes.
     * - Modified the outer loop index during traversal.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    /*
     * Problem Statement:
     * Given a circular array of non-zero integers, determine whether
     * the array contains a cycle.
     *
     * A cycle must:
     * - Contain more than one element.
     * - Move entirely in the same direction (positive or negative).
     * - Follow the next index calculated using the current value.
     */

    public static boolean circularArrayLoop(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int curr = i;
            boolean isPositive = nums[i] > 0;

            int slow = i;
            int fast = i;

            if (nums[curr] == 0)
                continue;

            do {
                slow = getNextIndex(nums, slow);

                fast = getNextIndex(nums, fast);

                if (isPositive) {
                    if (nums[fast] < 0)
                        break;
                } else {
                    if (nums[fast] > 0)
                        break;
                }

                fast = getNextIndex(nums, fast);

                if (isPositive) {
                    if (nums[fast] < 0)
                        break;
                } else {
                    if (nums[fast] > 0)
                        break;
                }

                if (slow == fast) {
                    if (slow != getNextIndex(nums, slow))
                        return true;
                    else
                        break;
                }

            } while (slow != fast);

            curr = i;

            if (isPositive) {
                while (nums[curr] > 0) {
                    int next = getNextIndex(nums, curr);
                    nums[curr] = 0;
                    curr = next;
                }
            } else {
                while (nums[curr] < 0) {
                    int next = getNextIndex(nums, curr);
                    nums[curr] = 0;
                    curr = next;
                }
            }
        }

        return false;
    }

    public static int getNextIndex(int[] arr, int index) {

        int curr = index;
        int next = arr[curr];

        int n = arr.length;

        if (next > 0) {
            curr = (curr + next) % n;
        } else {
            curr = ((curr + next) % n + n) % n;
        }

        return curr;
    }

    public static void main(String[] args) {

        // Test Case 1
        // Input: [2, -1, 1, 2, 2]
        // Expected: true
        int[] nums1 = { 2, -1, 1, 2, 2 };
        assert circularArrayLoop(nums1);

        // Test Case 2
        // Input: [-1, -2, -3, -4, -5, 6]
        // Expected: false
        int[] nums2 = { -1, -2, -3, -4, -5, 6 };
        assert !circularArrayLoop(nums2);

        // Test Case 3
        // Input: [1, 1, 1, 1, 1, 1]
        // Expected: true
        int[] nums3 = { 1, 1, 1, 1, 1, 1 };
        assert circularArrayLoop(nums3);

        // Test Case 4
        // Input: [1, -1, 5, 1, 4]
        // Expected: false
        int[] nums4 = { 1, -1, 5, 1, 4 };
        assert !circularArrayLoop(nums4);

        System.out.println("All test cases passed!");
    }
}