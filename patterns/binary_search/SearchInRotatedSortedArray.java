package patterns.binary_search;

public class SearchInRotatedSortedArray {
    /*
     * Problem : Search in Rotated Sorted Array
     * LeetCode : #33
     * Link:
     * https://leetcode.com/problems/search-in-rotated-sorted-array/
     * Pattern : Binary Search on Rotated Array
     * Difficulty : Medium
     * Date Solved: 31-05-2026
     * Revision : [✅] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used binary search on the rotated sorted array.
     * - Initialize start and end pointers
     * - Find the middle element
     * - If target is found, return its index
     * - Determine which half is sorted
     * - Check whether target lies inside the sorted half
     * - If yes, search that half
     * - Otherwise, search the other half
     * - Continue until target is found or search space becomes empty
     *
     * Why It Works:
     * In a rotated sorted array, at least one half is always sorted.
     * By identifying the sorted half and checking whether the target
     * lies within its range, we can safely eliminate half of the
     * search space every iteration.
     *
     * Left Half Sorted:
     * nums[start] <= nums[mid]
     *
     * Right Half Sorted:
     * nums[start] > nums[mid]
     *
     * Pattern Insight:
     * This is a Binary Search on Rotated Array problem.
     * The key idea is not to compare directly with the target only,
     * but first determine which side is sorted and then decide
     * where the target can possibly exist.
     *
     * Mistake I Made:
     * - Treated the rotated array like a normal sorted array.
     * - Compared target only with nums[mid].
     * - Forgot to identify the sorted half first.
     * - Used end = mid instead of end = mid - 1,
     * causing incorrect search boundaries.
     * - Eliminated the wrong half when the target was
     * outside the sorted range.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */

    // Given a rotated sorted array of unique elements,
    // return the index of target if present, otherwise -1.

    public static int search(int[] nums, int target) {
        int st = 0;
        int end = nums.length - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Left half is sorted
            if (nums[st] <= nums[mid]) {

                if (nums[st] <= target && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    st = mid + 1;
                }

            }
            // Right half is sorted
            else {

                if (nums[mid] < target && target <= nums[end]) {
                    st = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;

        System.out.println("Target Index: " + search(nums, target));
    }
}