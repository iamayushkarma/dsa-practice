package patterns.arrays;

import java.util.ArrayList;
import java.util.List;

public class FindDisappearedNumbers {
    /*
     * Problem : Find All Numbers Disappeared in an Array
     * LeetCode : #448
     * Link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
     * description/
     * Pattern : Array Index Marking (Cyclic Sort family)
     * Difficulty : Easy
     * Date Solved: 25-07-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * brute force approach is to use a HashSet/boolean array of size n+1, mark
     * every number present, then loop from 1 to n and collect the numbers not
     * marked as present. Works but uses O(n) extra space.
     *
     * Optimal Approach:
     * since nums contains numbers in range [1, n], we can use the array itself
     * as a hashmap. For every value val we visit, go to index (abs(val)-1) and
     * make that value negative to mark "number (index+1) is present". While
     * doing this always take abs(val) first because the value at that index
     * might already have been flipped negative by an earlier iteration.
     * After processing, any index i still holding a positive value means the
     * number (i+1) never appeared in the array, so collect those.
     *
     * Pattern Insight:
     * classic "use array indices as a hash set" trick - only works because
     * values are bounded in [1, n], same family as cyclic sort problems.
     *
     * Mistake I Made:
     * forgot to take abs() when reading nums[i] before negating it again,
     * which double-flips an already negative value back to positive and
     * silently breaks the marking.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) (excluding the output list)
     */
    // Given an array nums of n integers where nums[i] is in the range [1, n],
    // return an array of all the integers in the range [1, n] that do not
    // appear in nums.
    // - Optimal Approach
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for (int val : nums) {
            int i = Math.abs(val) - 1;
            nums[i] = -1 * Math.abs(nums[i]);
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                res.add(i + 1);
        }
        return res;
    }

    // - Brute Force Approach
    // public static List<Integer> findDisappearedNumbersBrute(int[] nums) {
    // int n = nums.length;
    // boolean[] present = new boolean[n + 1];
    // for (int val : nums) {
    // present[val] = true;
    // }
    // List<Integer> res = new ArrayList<>();
    // for (int i = 1; i <= n; i++) {
    // if (!present[i]) res.add(i);
    // }
    // return res;
    // }

    public static void main(String[] args) {
        int[] arr = { 4, 3, 2, 7, 8, 2, 3, 1 };
        System.out.println("Disappeared numbers are: " + findDisappearedNumbers(arr));
    }
}