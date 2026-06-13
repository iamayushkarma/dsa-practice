package patterns.binary_search;

public class BinarySearch {
    /*
     * Problem : Binary Search
     * LeetCode : #704
     * Link:
     * https://leetcode.com/problems/binary-search/
     * Pattern : Binary Search
     * Difficulty : Easy
     * Date Solved: 30-May-2026
     * Revision : [✅] Day3 [✅] Day7 [✅] Day14
     *
     * My Approach:
     * Used binary search on the sorted array.
     * - Initialize start and end pointers
     * - Find middle element
     * - If middle equals target, return its index
     * - If target is greater, search right half
     * - Otherwise, search left half
     * - Continue until target is found or search space becomes empty
     *
     * Why It Works:
     * Since the array is sorted, we can eliminate
     * half of the remaining elements after every comparison.
     * This drastically reduces the number of searches needed.
     *
     * Pattern Insight:
     * This is the classic Binary Search pattern.
     * Key idea: whenever the data is sorted,
     * compare with the middle element and discard
     * the half that cannot contain the answer.
     *
     * Mistake I Made:
     * - Forgot to calculate mid safely:
     * mid = start + (end - start) / 2
     * - Mixed up start and end updates.
     * - Tried linear search before recognizing
     * the array was sorted.
     * - Forgot to return -1 when target was not found.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    // Given a sorted array and a target value, return the target's index if it
    // exists; otherwise return -1 using binary search.
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int st = 0;
        int end = n - 1;

        while (st <= end) {
            int mid = st + (end - st) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target)
                end = mid - 1;
            else {
                st = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 3, 5, 9, 12 };
        int target = 9;

        System.out.println("Target index is: " + search(nums, target));

    }
}