package patterns.binary_search;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    /*
     * Problem : Find First and Last Position of Element in Sorted Array
     * LeetCode : #34
     * Link:
     * https://leetcode.com/problems/find-first-and-last-position-of-element-in-
     * sorted-array/
     * Pattern : Boundary Binary Search
     * Difficulty : Medium
     * Date Solved: 03-06-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * Approach:
     * - Use Binary Search twice.
     * - First search finds the leftmost occurrence.
     * - Second search finds the rightmost occurrence.
     * - When target is found:
     * - Store answer.
     * - Continue searching toward the boundary.
     *
     * Why It Works:
     * - Array is sorted.
     * - Binary Search can efficiently find both boundaries.
     * - Left search gives first occurrence.
     * - Right search gives last occurrence.
     *
     * Key Insight:
     * Don't stop when target is found.
     * Keep searching toward the required boundary.
     *
     * Mistakes I Made:
     * - Tried solving both positions in one search.
     * - Modified mid manually (mid--) which has no effect.
     * - Didn't move st/end after finding target.
     * - Got ArrayIndexOutOfBounds by storing too many indices.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */

    // Finds first occurrence of target
    public static int findFirst(int[] nums, int target) {
        int st = 0, end = nums.length - 1;
        int ans = -1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (nums[mid] == target) {
                ans = mid;
                end = mid - 1;
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    // Finds last occurrence of target
    public static int findLast(int[] nums, int target) {
        int st = 0, end = nums.length - 1;
        int ans = -1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (nums[mid] == target) {
                ans = mid;
                st = mid + 1;
            } else if (nums[mid] < target) {
                st = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return ans;
    }

    public static int[] searchRange(int[] nums, int target) {
        return new int[] {
                findFirst(nums, target),
                findLast(nums, target)
        };
    }

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;

        System.out.println(
                "First and Last Position: "
                        + Arrays.toString(searchRange(nums, target)));
    }
}