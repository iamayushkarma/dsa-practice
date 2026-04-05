public class BestTimeToBuyAndSellStockII {
    /*
     * Problem : Best time to buy and sell stock II
     * LeetCode : 122
     * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
     * Pattern : Greedy (Single Pass)
     * Difficulty : Easy
     * Date Solved: 05-04-2026
     * Revision : [] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * First i use brute force approch, i used nested loops to solve the problem
     *
     * Pattern Insight:
     * Greedy (Single Pass)
     *
     * Mistake I Made:
     * I was trying to solve it with two pointer i and j with two loops but coudn't
     * find the logic withing 30 minutes
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    // Given stock prices by day, find the maximum profit by buying on one day and
    // selling later. Return 0 if no profit is possible.
    public static int bestTimeToBuyStock(int[] nums) {
        int profit = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                profit += nums[i] - nums[i - 1];
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = { 8, 1, 2, 4, 6, 3, 7 };
        System.out.println("Maximum Profit is: " + bestTimeToBuyStock(arr));
    }

}
