package patterns.arrays;

public class MajorityElement {
    /*
     * Problem : Majority Element
     * LeetCode : #169
     * Link: https://leetcode.com/problems/majority-element/
     * Pattern : Boyer-Moore Voting / Hashing
     * Difficulty : Easy
     * Date Solved: 07-Apr-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Use a HashMap to count frequency of each element.
     * Traverse the array and store count of each number.
     * The element whose frequency is greater than n/2 is the majority element.
     *
     * Optimal Approach:
     * Use Boyer-Moore Voting Algorithm:
     * Maintain a candidate and a count.
     * If count becomes 0, update candidate.
     * If current number equals candidate → increment count
     * else decrement count.
     * Since majority element appears more than n/2 times,
     * it will always remain as the final candidate.
     *
     * Pattern Insight:
     * If a problem asks for element appearing more than n/2 times,
     * it is a strong signal for Boyer-Moore Voting Algorithm.
     * The idea is cancellation — majority element survives elimination.
     *
     * Mistake I Made:
     * Initially only thought of HashMap (extra space).
     * Missed the fact that this problem can be solved in O(1) space.
     *
     * Time Complexity:
     * HashMap → O(n)
     * Boyer-Moore → O(n)
     *
     * Space Complexity:
     * HashMap → O(n)
     * Boyer-Moore → O(1)
     */

    public static int majorityElement(int[] nums) {
        int freq = 0;
        int el = 0;

        for (int num : nums) {
            if (freq == 0)
                el = num;
            freq += (num == el) ? +1 : -1;
        }
        return el;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };

        int result = majorityElement(nums);

        System.out.println("Majority Element: " + result);
    }
}