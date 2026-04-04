package patterns.two_pointers;

import java.util.*;

public class ThreeSum {
    /*
     * Problem : 3 Sum
     * LeetCode : #15
     * Link: https://leetcode.com/problems/3sum/description/
     * Pattern : Two Pointers
     * Difficulty : Medium
     * Date Solved: 04-04-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * First thought was brute force — try all triplets using 3 loops
     * and check if sum == 0. This works but takes O(n^3) time, which is too slow.
     *
     * Then improved by sorting the array and fixing one element,
     * and using two pointers (left, right) to find the remaining two numbers.
     *
     * Optimal Approach:
     * 1. Sort the array.
     * 2. Fix one element (i).
     * 3. Use two pointers:
     * - left = i + 1
     * - right = n - 1
     * 4. If sum == 0 → store triplet and move both pointers
     * 5. If sum < 0 → move left++
     * 6. If sum > 0 → move right--
     * 7. Skip duplicates for i, left, and right to avoid repeated answers
     *
     * Sorting helps apply two-pointer logic efficiently.
     * 
     * Pattern Insight:
     * Two Pointers (3 pointer variation)
     *
     * Mistake I Made:
     * (What did you get wrong? What edge case did you miss?)
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(1) (excluding result list)
     */
    // Given an integer array nums, return all the triplets [nums[i], nums[j],
    // nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
    // nums[k] == 0.

    public static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];

                if (sum == 0) {
                    ans.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1])
                        j++;
                    while (j < k && arr[k] == arr[k + 1])
                        k--;
                } else if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] arr) {
        int[] ans = { -1, 0, 1, 2, -1, -4 };
        System.out.println("Triplets whose sum is 0, are: " + threeSum(ans));
    }
}
