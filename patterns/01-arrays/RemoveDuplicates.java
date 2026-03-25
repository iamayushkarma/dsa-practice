
public class RemoveDuplicates {
    /*
     * Problem : Remove duplicates for sorted array
     * LeetCode : 26
     * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
     * description/
     * Pattern : Two Pointers
     * Difficulty : Easy
     * Date Solved: 25-03-2025
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * I was trying to solve it with two pointer i and j with two loops but coudn't
     * find the logic
     *
     * Optimal Approach:
     * (Write the most efficient solution and why it works)
     *
     * Pattern Insight:
     * Two Pointers
     *
     * Mistake I Made:
     * I was trying to solve it with two pointer i and j with two loops but coudn't
     * find the logic withing 30 minutes
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    // Given a sorted array nums, remove duplicates in-place so each element appears
    // once. Keep the same order and return k, the number of unique elements. The
    // first k positions should contain the unique values.
    public static int removeDuplicates(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                continue;
            } else {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println("Length of sorted array is: " + removeDuplicates(arr));
    }

}
