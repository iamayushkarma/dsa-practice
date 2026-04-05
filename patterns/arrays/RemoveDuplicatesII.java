public class RemoveDuplicatesII {
    /*
     * Problem : Remove duplicates for sorted array II
     * LeetCode : 80
     * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
     * description/
     * Pattern : Two Pointers
     * Difficulty : Medium
     * Date Solved: 05-04-2026
     * Revision : [] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * I was trying to solve it with two pointer i and j with two loops but coudn't
     * find the logic
     *
     * Optimal Approach:
     * We can keep at most two duplicate elements, so what we will do is
     * 1.take a var count
     * 2.start the loop from i=2
     * 3.if this condation "nums[i] != nums[count - 2]" matched we sill cnage the
     * value of nums[count] and nums[i]
     * 4.after that count++
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

    // Given a sorted array nums, remove duplicates in-place so that each element
    // appears at most twice. Maintain the original order and return k, the number
    // of valid elements. The first k positions of the array should contain the
    // result. Do not use extra space (O(1) memory).
    public static int removeDuplicatesII(int[] nums) {
        int count = 2;
        if (nums.length <= 2)
            return nums.length;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[count - 2]) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
        System.out.println("Length of sorted array is: " + removeDuplicatesII(arr));
    }
}
