package patterns.sliding_window;

public class GetEqualSubstringsWithinBudget {
    /*
     * Problem : Get Equal Substrings Within Budget
     * LeetCode : #1208
     * Link:
     * https://leetcode.com/problems/get-equal-substrings-within-budget/
     * Pattern : Sliding Window
     * Difficulty : Medium
     * Date Solved: __-__-____
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used variable-size sliding window.
     * - Calculate conversion cost for each character:
     * Math.abs(s.charAt(i) - t.charAt(i))
     * - Expand window and add current cost to running sum
     * - If total cost exceeds maxCost,
     * shrink window from left until cost becomes valid
     * - Track maximum valid window length
     *
     * Why It Works:
     * Any substring is valid only if the total conversion
     * cost is less than or equal to maxCost.
     * Sliding window helps maintain the largest valid
     * substring while processing each character once.
     *
     * Pattern Insight:
     * This is a variable-size sliding window problem.
     * Key idea: maintain a window whose total cost
     * remains within the given budget.
     * When the budget is exceeded, shrink the window
     * until it becomes valid again.
     *
     * Mistake I Made:
     * - Initially tried comparing characters directly
     * instead of tracking cumulative conversion cost.
     * - Forgot to subtract the left character's cost
     * while shrinking the window.
     * - Considered restarting the window instead of
     * maintaining it dynamically.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    // You can convert characters in s to match t, where changing a character costs
    // the difference between their ASCII values. Find the longest continuous
    // substring that can be converted while keeping the total cost within maxCost.
    public static int equalSubstring(String s, String t, int maxCost) {
        if (s.equals(t))
            return s.length();
        int s_len = s.length();
        int t_len = t.length();
        int ws = 0, we = 0;
        int inti_cost = 0;
        int result = 0;
        while (we < s_len) {
            char s_ch = s.charAt(we);
            char t_ch = t.charAt(we);

            inti_cost += Math.abs(t_ch - s_ch);
            while (inti_cost > maxCost) {
                inti_cost -= Math.abs(s.charAt(ws) - t.charAt(ws));
                ws++;
            }
            we++;
            result = Math.max(we - ws, result);
        }
        return result;
    }

    public static void main(String[] args) {
        String str1 = "abcd", str2 = "cdef";
        int maxCost = 1;
        System.out.println("Maximum length of substring is: " + equalSubstring(str1, str2, maxCost));
    }
}