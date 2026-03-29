import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    /*
     * Problem : Two Sum
     * LeetCode : #01
     * Link: https://leetcode.com/problems/two-sum/description/
     * Pattern : Hashing
     * Difficulty : Easy
     * Date Solved: 25-03-2026
     * Revision : [✅] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * brute force approch is the run nested loops using i and j and check for
     * condation "nums[i] + nums[j] == target" and if its true return them into an
     * array
     *
     * Optimal Approach:
     * Using HashMap beacouse it have O(1) for getting element, so just checked that
     * is the inserting value subtracted by the traget exist if it does simply
     * return it
     *
     * Pattern Insight:
     * hashing pattern
     *
     * Mistake I Made:
     * First I used HashSet the i got stuck between the value and index mismatch
     * then i switched to HashMap that resolves this issue
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    // Given an integer array nums and a target, return the indices of two
    // distinct elements whose sum equals the target. Exactly one solution exists,
    // and the order of indices doesn’t matter.”

    // - Optimal Approch
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int reqValue = target - nums[i];
            if (map.containsKey(reqValue)) {
                return new int[] { map.get(reqValue), i };
            }
            map.put(nums[i], i);
        }
        return new int[] { -1, -1 };
    }

    // - Brute Force Approch
    // public static int[] TwoSum(int[] nums, int target) {
    // int n = nums.length;

    // for (int i = 0; i < n; i++) {
    // for (int j = i + 1; j < n; j++) {
    // if (nums[i] + nums[j] == target) {

    // return new int[] { i, j };
    // }
    // }
    // }
    // return new int[] { -1, -1 };
    // }

    public static void main(String[] args) {
        int[] arr = { 2, 7, 11, 15, 3, 6, 9, 4 };
        int target = 13;
        System.out.println("Resultent array is: " + Arrays.toString(twoSum(arr, target)));
    }
}
