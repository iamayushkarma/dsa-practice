package patterns.binary_search;

public class SqrtX {

    /**
     * Problem : Sqrt(x)
     * LeetCode : #69
     * Link: https://leetcode.com/problems/sqrtx/
     * Pattern : Binary Search on Answer
     * Difficulty : Easy
     * Date Solved: 08-10-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used binary search to find the integer square root.
     *
     * - Set the search space from 1 to x.
     * - Find the middle element.
     * - Calculate mid * mid.
     * - If mid * mid equals x, return mid.
     * - If mid * mid is greater than x, search the left half.
     * - If mid * mid is smaller than x, search the right half.
     *
     * Why It Works:
     * We need the largest integer whose square is less than or equal to x.
     *
     * If:
     *
     * mid * mid > x
     *
     * mid is too large, so we move left.
     *
     * If:
     *
     * mid * mid < x
     *
     * mid can be a valid answer, but a larger answer may exist,
     * so we move right.
     *
     * If:
     *
     * mid * mid == x
     *
     * We found the exact square root.
     *
     * Pattern Insight:
     * We are searching for the largest value that satisfies
     * the condition:
     *
     * mid * mid <= x
     *
     * Key observation:
     *
     * Square too large -> move left
     * Square too small -> move right
     * Exact square -> return mid
     *
     * Since the answer must be an integer, if no exact square root
     * exists, the answer is st - 1 after the binary search ends.
     *
     * Mistake I Made:
     * - Used int for mid * mid, which can cause integer overflow.
     * - Returned st instead of st - 1 after the search.
     *
     * Time Complexity:
     * O(log x)
     *
     * Space Complexity:
     * O(1)
     */

    // Return integer square root of x.
    public static int mySqrt(int x) {
        int st = 1, end = x;

        while (st <= end) {
            int mid = st + (end - st) / 2;

            long sqr = (long) mid * mid;

            if (sqr == x)
                return mid;
            else if (sqr > x)
                end = mid - 1;
            else
                st = mid + 1;
        }

        return st - 1;
    }

    public static void main(String[] args) {
        int x = 8;
        System.out.println("Square Root: " + mySqrt(x));
    }
}