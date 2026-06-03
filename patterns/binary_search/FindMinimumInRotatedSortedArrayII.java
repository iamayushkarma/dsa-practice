package patterns.binary_search;

public class FindMinimumInRotatedSortedArrayII {
    /*
     * Problem : Find Minimum in Rotated Sorted Array II
     * LeetCode : #154
     * Link:
     * https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
     * Pattern : Binary Search on Rotated Array with Duplicates
     * Difficulty : Hard
     * Date Solved: 31-05-2026
     * Revision : [✅] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used binary search to locate the minimum element.
     * - Initialize start and end pointers
     * - Find the middle element
     * - Compare nums[mid] with nums[end]
     * - If nums[mid] > nums[end], minimum lies in the right half
     * - If nums[mid] < nums[end], minimum lies in the left half
     * (including mid)
     * - If nums[mid] == nums[end], we cannot determine which
     * half contains the minimum due to duplicates
     * - Safely shrink the search space by decrementing end
     * - Continue until start == end
     * - Return nums[start]
     *
     * Why It Works:
     * In a rotated sorted array, comparing nums[mid] with
     * nums[end] tells us which side contains the pivot.
     *
     * nums[mid] > nums[end]
     * -> Minimum must be in the right half
     *
     * nums[mid] < nums[end]
     * -> Minimum must be in the left half including mid
     *
     * nums[mid] == nums[end]
     * -> Duplicates create ambiguity.
     * We cannot identify the correct half.
     * Removing one duplicate from the end does not
     * lose the minimum element.
     *
     * Pattern Insight:
     * This is an extension of LeetCode 153.
     * The presence of duplicates breaks the guarantee that
     * one comparison can always identify the correct half.
     * When duplicates appear, we may need to shrink the
     * search space linearly.
     *
     * Mistake I Made:
     * - Compared nums[mid] with nums[start] and nums[end]
     * simultaneously.
     * - Tried removing duplicates from both sides before
     * making a binary search decision.
     * - Continued normal binary search after modifying
     * start/end in the same iteration.
     * - Forgot that nums[mid] == nums[end] is the only
     * ambiguous case that needs special handling.
     *
     * Time Complexity:
     * Best/Average: O(log n)
     * Worst Case: O(n) (all elements are duplicates)
     *
     * Space Complexity: O(1)
     */

    // Given a rotated sorted array that may contain duplicates,
    // return the minimum element.

    public static int findMin(int[] nums) {
        int st = 0;
        int end = nums.length - 1;

        while (st < end) {
            int mid = st + (end - st) / 2;

            if (nums[mid] > nums[end]) {
                st = mid + 1;
            } else if (nums[mid] < nums[end]) {
                end = mid;
            } else {
                end--;
            }
        }

        return nums[st];
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 0, 1 };

        System.out.println("Minimum Element: " + findMin(nums));
    }
}