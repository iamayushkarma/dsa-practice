package patterns.two_pointers;

import java.util.Arrays;

public class MoveZeroes {
    /*
     * Problem : Move Zeroes
     * LeetCode : #283
     * Link: https://leetcode.com/problems/move-zeroes/
     * Pattern : Two Pointers
     * Difficulty : Easy
     * Date Solved: 08-Apr-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * Problem Statement (short):
     * Move all 0s to the end of the array while maintaining the relative order of
     * non-zero elements.
     *
     * My Approach:
     * First thought was to create a new array and copy all non-zero elements,
     * then fill remaining positions with 0s. But this uses extra space.
     *
     * Then optimized by using two pointers:
     * - One pointer (i) scans the array
     * - One pointer (idx) keeps track of position to place next non-zero
     *
     * Optimal Approach:
     * 1. Initialize idx = 0
     * 2. Traverse array using i
     * 3. If nums[i] != 0 → swap nums[i] with nums[idx], then idx++
     * 4. Continue till end
     *
     * This keeps all non-zero elements in order and pushes zeros to the end.
     *
     * Pattern Insight:
     * Two Pointers (stable partition)
     *
     * Mistake I Made:
     * - Forgot to call the function in main()
     * - Overthought with extra array instead of in-place solution
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    // Given an integer array nums, move all 0's to the end of it while maintaining
    // the relative order of the non-zero elements.

    public static int[] moveZeroes(int[] nums) {
        int n = nums.length;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp;
                idx++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 1, 0, 3, 12 };
        System.out.println("Array after moving all 0's to end: " + Arrays.toString(moveZeroes(arr)));
    }
}
