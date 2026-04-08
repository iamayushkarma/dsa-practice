import java.util.*;

public class ThreeSum {
    /*
     * Problem : 3Sum
     * LeetCode : #15
     * Link: https://leetcode.com/problems/3sum/
     * Pattern : Two Pointers + Sorting
     * Difficulty : Medium
     * Date Solved: 08-Apr-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * First, sort the array so that we can use two pointers.
     * Fix one element (i), then use two pointers (j and k)
     * to find pairs such that arr[i] + arr[j] + arr[k] = 0.
     *
     * Optimal Approach:
     * Sort the array. For each element, use two pointers:
     * one starting from left (j = i+1) and one from right (k = n-1).
     * Move pointers based on sum:
     * - If sum < 0 → increase j
     * - If sum > 0 → decrease k
     * - If sum == 0 → store result and skip duplicates
     *
     * Pattern Insight:
     * Whenever the problem involves finding triplets or pairs with a condition,
     * sorting + two pointers is a strong hint.
     *
     * Mistake I Made:
     * 1. Wrong duplicate check: used (i < 0) instead of (i > 0)
     * 2. Infinite loop: used "continue" instead of moving pointer
     * 3. Forgot to skip duplicates properly for both j and k
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) (excluding result list)
     */

    // Given an integer array nums, return all the triplets [nums[i], nums[j],
    // nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
    // nums[k] == 0.
    public static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            if (i < 0 && arr[i] == arr[i - 1])
                continue;
            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum < 0)
                    j++;
                else if (sum > 0)
                    k--;
                else {
                    list.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k])));
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1])
                        j++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4 };
        System.out.println("Triplate with sum 0 is: " + threeSum(arr));
    }
}
