package patterns.binary_search;

public class FindMinimumInRotatedSortedArray {
    /*
     * Problem : Find Minimum in Rotated Sorted Array
     * LeetCode : #153
     * Link:
     * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
     * Pattern : Binary Search on Rotated Array
     * Difficulty : Medium
     * Date Solved: 31-05-2026
     * Revision : [✅] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used binary search to locate the minimum element.
     * - Initialize start and end pointers
     * - Find the middle element
     * - Compare nums[mid] with nums[end]
     * - If nums[mid] > nums[end], minimum lies in the right half
     * - Otherwise, minimum lies in the left half (including mid)
     * - Continue shrinking the search space until start == end
     * - Return nums[start]
     *
     * Why It Works:
     * In a rotated sorted array, one half is always sorted.
     * Comparing nums[mid] with nums[end] tells us whether
     * the rotation point (minimum element) is to the left
     * or right of mid.
     *
     * If nums[mid] > nums[end]:
     * Minimum must be in the right half
     *
     * If nums[mid] <= nums[end]:
     * Minimum is in the left half including mid
     *
     * Pattern Insight:
     * This is a Binary Search on Answer Space problem.
     * Instead of searching for a target value, we search
     * for the pivot (rotation point) where the minimum exists.
     *
     * Mistake I Made:
     * - Compared nums[start] and nums[end] instead of
     * nums[mid] and nums[end].
     * - Updated start/end without knowing which side
     * actually contained the minimum.
     * - Used while(start <= end), making the logic
     * more complicated.
     * - Stored mid as the answer instead of narrowing
     * the search space correctly.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */

    // Given a rotated sorted array of unique elements,
    // return the minimum element.

    public static int findMin(int[] nums) {
        int st = 0;
        int end = nums.length - 1;

        while (st < end) {
            int mid = st + (end - st) / 2;

            if (nums[mid] > nums[end]) {
                st = mid + 1;
            } else {
                end = mid;
            }
        }

        return nums[st];
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };

        System.out.println("Minimum Element: " + findMin(nums));
    }
}