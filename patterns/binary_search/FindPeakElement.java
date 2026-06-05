package patterns.binary_search;

public class FindPeakElement {
    /*
     * Problem : Find Peak Element
     * LeetCode : #162
     * Link:
     * https://leetcode.com/problems/find-peak-element/
     * Pattern : Binary Search on Unsorted Array
     * Difficulty : Medium
     * Date Solved: 31-05-2026
     * Revision : [✅] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used binary search to locate a peak element.
     *
     * - Find middle element.
     * - Check whether we are on an ascending slope.
     * - Check whether we are on a descending slope.
     * - Move toward the side that must contain a peak.
     * - If current element is greater than both neighbors,
     * return its index.
     *
     * Why It Works:
     * A peak element is greater than its adjacent elements.
     *
     * If:
     *
     * nums[mid] < nums[mid + 1]
     *
     * We are on an ascending slope.
     * A peak must exist on the right side.
     *
     * If:
     *
     * nums[mid] < nums[mid - 1]
     *
     * We are on a descending slope.
     * A peak must exist on the left side.
     *
     * Otherwise:
     *
     * nums[mid] is greater than both neighbors,
     * making it a peak.
     *
     * Pattern Insight:
     * We are not searching for a specific value.
     * We are searching for a position that satisfies
     * a condition.
     *
     * Key observation:
     *
     * Ascending slope -> move right
     * Descending slope -> move left
     *
     * A peak is guaranteed to exist.
     *
     * Mistake I Made:
     * - Tried checking every element linearly.
     * - Forgot that slopes provide enough information
     * to eliminate half of the search space.
     * - Confused peak value with peak index.
     *
     * Time Complexity:
     * O(log n)
     *
     * Space Complexity:
     * O(1)
     */

    // Return index of any peak element.

    public static int findPeakElement(int[] nums) {
        int n = nums.length;

        int st = 0, end = n - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (mid < end && nums[mid] < nums[mid + 1]) {
                st = mid + 1;
            } else if (mid > st && nums[mid] < nums[mid - 1]) {
                end = mid;
            } else {
                return mid;
            }
        }

        return st;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 1 };
        System.out.println("Peak Index: " + findPeakElement(nums));
    }
}