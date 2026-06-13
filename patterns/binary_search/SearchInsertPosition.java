package patterns.binary_search;

public class SearchInsertPosition {
    /*
     * Problem : Search Insert Position
     * LeetCode : #35
     * Link:
     * https://leetcode.com/problems/search-insert-position/
     * Pattern : Binary Search
     * Difficulty : Easy
     * Date Solved: 30-05-2026
     * Revision : [✅] Day3 [✅] Day7 [✅] Day14
     *
     * My Approach:
     * Used binary search on the sorted array.
     * - Initialize start and end pointers
     * - Find middle element
     * - If target is found, return its index
     * - If target is greater, search right half
     * - Otherwise, search left half
     * - When the search ends, start pointer indicates
     * the correct insertion position
     *
     * Why It Works:
     * Binary search narrows down the location where
     * the target should exist. If the target is not found,
     * the start pointer ends up at the exact position
     * where the target should be inserted to maintain
     * sorted order.
     *
     * Pattern Insight:
     * This is a Binary Search variant.
     * Key idea: instead of returning -1 when the target
     * is not found, return the position where it would
     * be inserted.
     *
     * Mistake I Made:
     * - Returned -1 when target was absent.
     * - Forgot that start becomes the insertion index
     * after the loop finishes.
     * - Mixed up start and end updates.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */

    // Given a sorted array and a target value, return its index
    // if found; otherwise return the position where it should be inserted.

    public static int searchInsert(int[] nums, int target) {
        int st = 0;
        int end = nums.length - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return st;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 6 };
        int target = 2;

        System.out.println("Position is: " + searchInsert(nums, target));
    }
}