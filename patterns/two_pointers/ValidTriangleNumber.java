package patterns.two_pointers;

import java.util.Arrays;

public class ValidTriangleNumber {

    /**
     * Problem : Valid Triangle Number
     * LeetCode : #611
     * Link: https://leetcode.com/problems/valid-triangle-number/
     * Pattern : Two Pointers / Sorting
     * Difficulty : Medium
     * Date Solved: 08-09-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     *
     * My Approach:
     * First, sort the array so that the elements are arranged
     * in increasing order.
     *
     * Then fix the largest side at index k and use two pointers:
     * i starts from the beginning and j starts just before k.
     *
     * For every pair of i and j, check whether:
     *
     * nums[i] + nums[j] > nums[k]
     *
     * If the condition is true, then every element between i
     * and j - 1 can also form a valid triangle with nums[j]
     * and nums[k], because the array is sorted.
     *
     * Therefore, we can add j - i directly to the count
     * instead of checking every possible pair individually.
     *
     * If the condition is false, nums[i] is too small, so
     * we move i forward.
     *
     *
     * Optimal Approach:
     * 1. Sort the array.
     * 2. Fix k as the largest side, starting from the end.
     * 3. Set i = 0 and j = k - 1.
     * 4. Check if nums[i] + nums[j] > nums[k].
     * 5. If true, add j - i to count and move j backward.
     * 6. Otherwise, move i forward.
     * 7. Repeat until i >= j.
     * 8. Return the total count.
     *
     *
     * Pattern Insight:
     * Sorting + Two Pointers
     *
     *
     * The key idea is:
     *
     * After sorting, if:
     *
     * nums[i] + nums[j] > nums[k]
     *
     * then every index between i and j - 1 also forms
     * a valid triangle with j and k.
     *
     * Therefore:
     *
     * count += j - i
     *
     * This allows us to count multiple valid triangles at once
     * instead of checking every combination individually.
     *
     *
     * Time Complexity: O(n²)
     * Space Complexity: O(1) extra space
     */

    // You are given an integer array nums.
    //
    // Return the number of triplets chosen from the array
    // that can make triangles if we take them as side lengths.
    //
    // For three sides a, b and c to form a triangle:
    //
    // a + b > c
    //
    // After sorting, c will always be the largest side.

    public static int triangleNumber(int[] nums) {

        Arrays.sort(nums);

        int n = nums.length;
        int count = 0;

        for (int k = n - 1; k >= 2; k--) {

            int i = 0;
            int j = k - 1;

            while (i < j) {

                if (nums[i] + nums[j] > nums[k]) {

                    count += j - i;
                    j--;

                } else {

                    i++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[] nums = {2, 2, 3, 4};

        System.out.println(triangleNumber(nums));
    }
}