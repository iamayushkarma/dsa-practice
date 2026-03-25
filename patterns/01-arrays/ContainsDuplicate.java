
import java.util.HashSet;

public class ContainsDuplicate {

    /*
     * Problem : Contains Duplicate
     * LeetCode : 217
     * Link: https://leetcode.com/problems/contains-duplicate/
     * Pattern : Hashing
     * Difficulty : Easy
     * Date Solved: 25-03-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * Optimal Approach:
     * Using HashSet for check is HashSet already has that value it will return true
     * else false.
     *
     * Pattern Insight:
     * Hashing
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    // Given an integer array nums, return true if any value appears at least twice
    // in the array, and return false if every element is distinct.

    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int el : nums) {
            if (set.contains(el))
                return true;
            set.add(el);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 4 };
        System.out.println("Are duplicate values present: " + containsDuplicate(arr));
    }
}
