package patterns.binary_search;

public class SearchInRotatedSortedArrayII {
    /*
     * Problem : Search in Rotated Sorted Array II
     * LeetCode : #81
     * Link:
     * https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
     * Pattern : Binary Search on Rotated Array with Duplicates
     * Difficulty : Medium
     * Date Solved: 31-05-2026
     * Revision : [✅] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used binary search on a rotated sorted array that may
     * contain duplicates.
     *
     * - Initialize start and end pointers
     * - Find the middle element
     * - If target is found, return true
     * - If start, mid and end are equal, duplicates create
     * ambiguity, so shrink the search space from both ends
     * - Otherwise determine which half is sorted
     * - Check whether target lies inside the sorted half
     * - Search the appropriate half
     * - Return false if target is not found
     *
     * Why It Works:
     * In a rotated sorted array, at least one side is sorted.
     * Normally we identify the sorted half and decide whether
     * the target belongs there.
     *
     * However, duplicates can destroy this information.
     *
     * Example:
     * [1,1,1,1,2,1,1]
     *
     * Here:
     * nums[start] == nums[mid] == nums[end]
     *
     * We cannot determine which side is sorted.
     * The only safe option is to shrink the search space
     * until enough information becomes available.
     *
     * Pattern Insight:
     * This is an extension of LeetCode 33.
     *
     * LC 33:
     * - No duplicates
     * - One side is always identifiable
     * - O(log n)
     *
     * LC 81:
     * - Duplicates allowed
     * - Sorted side may become ambiguous
     * - Worst case degrades to O(n)
     *
     * Mistake I Made:
     * - Forgot to handle the ambiguous duplicate case:
     * nums[start] == nums[mid] == nums[end]
     *
     * - Continued execution after shrinking duplicates
     * instead of restarting the loop.
     *
     * - Used incorrect target range checks for the
     * sorted right half.
     *
     * - Treated the problem exactly like LC 33 even
     * though duplicates remove information.
     *
     * Time Complexity:
     * Average: O(log n)
     * Worst Case: O(n)
     *
     * Space Complexity: O(1)
     */

    // Given a rotated sorted array that may contain duplicates,
    // return true if target exists, otherwise false.

    public static boolean search(int[] nums, int target) {
        int st = 0;
        int end = nums.length - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Ambiguous case caused by duplicates
            if (nums[st] == nums[mid] && nums[mid] == nums[end]) {
                st++;
                end--;
                continue;
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

        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 5, 6, 0, 0, 1, 2 };
        int target = 0;

        System.out.println("Target Found: " + search(nums, target));
    }
}