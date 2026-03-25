
public class BestTimeToBuyAndSellStock {
    /*
     * Problem : Best time to buy and sell stock
     * LeetCode : 121
     * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
     * Pattern : Greedy (Single Pass)
     * Difficulty : Easy
     * Date Solved: 25-03-2025
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
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
        if (nums.length == 0)
            return 0;
        int maxProfit = 0;
        int buyPrice = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int currProfit = nums[i] - buyPrice;
            if (currProfit > maxProfit) {
                maxProfit = currProfit;
            }
            if (nums[i] < buyPrice) {
                buyPrice = nums[i];
            }
        }
        return maxProfit;
    }

    // Brute Force
    // public static int bestTimeToBuyStock(int[] nums) {
    // int price = Integer.MIN_VALUE;
    // for (int i = 0; i < nums.length; i++) {
    // for (int j = i + 1; j < nums.length; j++) {
    // price = Math.max(price, nums[j] - nums[i]);
    // }
    // }
    // return (price < 0) ? 0 : price;
    // }

    public static void main(String[] args) {
        int[] arr = { 8, 1, 2, 4, 6, 3, 7 };
        System.out.println("Maximum Profit is: " + bestTimeToBuyStock(arr));
    }

}
