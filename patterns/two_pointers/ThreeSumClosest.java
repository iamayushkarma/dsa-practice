package patterns.two_pointers;

import java.util.Arrays;

public class ThreeSumClosest {

    /**
     * Problem : 3Sum Closest
     * LeetCode : #16
     * Link: https://leetcode.com/problems/3sum-closest/
     * Pattern : Two Pointers
     * Difficulty : Medium
     * Date Solved: 21-08-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * First thought was brute force — try all possible triplets (i, j, k)
     * and calculate their sum, then find the sum closest to the target.
     * This takes O(n^3) time and is too slow for large inputs.
     *
     * Then moved to a two-pointer approach:
     * First sort the array so that we can use the two-pointer technique.
     * Fix one element using i and use two pointers j and k
     * to find the remaining two elements whose sum makes the total
     * as close as possible to the target.
     *
     * Optimal Approach:
     * 1. Sort the array.
     * 2. Fix the first element using i.
     * 3. Place two pointers:
     * - j at i + 1
     * - k at the end
     * 4. Calculate sum = nums[i] + nums[j] + nums[k].
     * 5. Keep track of the sum closest to target.
     * 6. Move the pointers based on the current sum:
     * - If sum > target → k--
     * - If sum < target → j++
     * - If sum == target → return sum immediately.
     * 7. Repeat until j >= k.
     *
     * Pattern Insight:
     * Two Pointers + Sorting
     *
     * Sorting allows us to decide which pointer to move based on
     * whether the current sum is greater or smaller than the target.
     * If the sum is too large, decrease k to reduce the sum.
     * If the sum is too small, increase j to increase the sum.
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */

    // You are given an integer array and a target value. Your task is to
    // choose three different elements whose sum is closest to the target
    // and return that closest sum.

    public static int closestNumber(int target, int num1, int num2) {

        if (num1 == num2)
            return num1;

        int value1 = Math.abs(num1 - target);
        int value2 = Math.abs(num2 - target);

        if (value1 > value2)
            return num2;
        else
            return num1;
    }

    public static int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int n = nums.length;
        int finalSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < n - 2; i++) {

            int j = i + 1;
            int k = n - 1;

            while (j < k) {

                int sum = nums[i] + nums[j] + nums[k];

                finalSum = closestNumber(target, sum, finalSum);

                if (sum == target)
                    return sum;
                else if (sum > target)
                    k--;
                else
                    j++;
            }
        }

        return finalSum;
    }

    public static void main(String[] args) {

        int[] nums = { -1, 2, 1, -4 };
        int target = 1;

        System.out.println(
                "Closest sum: " + threeSumClosest(nums, target));
    }
}