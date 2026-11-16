package patterns.slow_fast_pointers;

public class HappyNumber {

    /*
     * Problem : Happy Number
     * LeetCode : #202
     * Link: https://leetcode.com/problems/happy-number/
     * Pattern : Floyd's Cycle Detection (Fast & Slow Pointers)
     * Difficulty : Easy
     * Date Solved: 16-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Use a HashSet to store previously visited numbers.
     * If the number becomes 1, return true.
     * If a number repeats, a cycle exists, so return false.
     *
     * Optimal Approach:
     * Use Floyd's Cycle Detection.
     * Slow pointer moves one transformation at a time.
     * Fast pointer moves two transformations at a time.
     * When both pointers meet, check whether the meeting
     * value is 1.
     *
     * Pattern Insight:
     * Every number generates a deterministic sequence by
     * repeatedly calculating the sum of squared digits.
     *
     * Every positive integer eventually reaches 1 or enters
     * a cycle. Slow and fast pointers detect that cycle
     * without storing previously visited numbers.
     *
     * Mistake I Made:
     * Initially used a HashSet instead of Floyd's Cycle
     * Detection. The HashSet approach works but requires
     * O(n) auxiliary space.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */

    /*
     * Problem Statement:
     * A happy number is a number defined by the following process:
     *
     * Replace the number with the sum of the squares of its digits.
     * Repeat this process until the number becomes 1 or enters
     * an endless cycle.
     *
     * Return true if the number is happy, otherwise return false.
     */

    public static boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        // Detect cycle using slow and fast pointers
        while (true) {
            slow = getSquares(slow);
            fast = getSquares(getSquares(fast));

            if (slow == fast)
                break;
        }

        return slow == 1;
    }

    // Calculate the sum of squares of digits
    public static int getSquares(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {

        // Test Case 1: Happy number
        assert isHappy(19);

        // Test Case 2: Not a happy number
        assert !isHappy(2);

        // Test Case 3: Already 1
        assert isHappy(1);

        // Test Case 4: Another happy number
        assert isHappy(7);

        // Test Case 5: Another non-happy number
        assert !isHappy(4);

        System.out.println("All test cases passed!");
    }
}