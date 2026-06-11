package patterns.stack;

import java.util.ArrayList;
import java.util.Stack;

public class OnlineStockSpan {

    /*
     * Problem : Online Stock Span
     * LeetCode : #901
     * Link : https://leetcode.com/problems/online-stock-span/
     * Pattern : Monotonic Stack (Decreasing Stack)
     * Difficulty : Medium
     * Date Solved : 11-Jun-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * ---------------------------------------------------------
     *
     * Problem Statement:
     *
     * Design a data structure that collects daily stock prices
     * and returns the stock span for the current day's price.
     *
     * Stock Span:
     *
     * Number of consecutive days (including today)
     * for which the stock price was less than or equal
     * to today's price.
     *
     * Example:
     *
     * Prices:
     * [100, 80, 60, 70, 60, 75, 85]
     *
     * Spans:
     * [1, 1, 1, 2, 1, 4, 6]
     *
     * ---------------------------------------------------------
     *
     * My Initial Thought:
     *
     * For every new price:
     * Move backward and count how many previous prices
     * are less than or equal to the current price.
     *
     * Example:
     *
     * Current Price = 85
     *
     * Check:
     * 75 ✓
     * 60 ✓
     * 70 ✓
     * 60 ✓
     * 80 ✓
     * 100 ✗
     *
     * Span = 6
     *
     * This works but requires traversing backward every time.
     *
     * Time Complexity:
     * O(n²)
     *
     * Too slow.
     *
     * ---------------------------------------------------------
     *
     * Key Observation:
     *
     * We don't actually care about all previous prices.
     *
     * We only care about:
     *
     * Previous Greater Price
     *
     * Because:
     *
     * Span =
     * Current Index - Previous Greater Index
     *
     * Example:
     *
     * Prices:
     *
     * Index: 0 1 2 3 4 5 6
     * Price:100 80 60 70 60 75 85
     *
     * Current Price = 85
     *
     * Previous Greater Price = 100
     * Previous Greater Index = 0
     *
     * Current Index = 6
     *
     * Span = 6 - 0 = 6
     *
     * ---------------------------------------------------------
     *
     * Optimal Approach:
     *
     * Use a Monotonic Decreasing Stack.
     *
     * Stack stores indices.
     *
     * Why indices?
     *
     * Because we need:
     *
     * Span =
     * Current Index - Previous Greater Index
     *
     * ---------------------------------------------------------
     *
     * Stack Property:
     *
     * Prices corresponding to stack indices
     * remain strictly decreasing.
     *
     * Example:
     *
     * Stack:
     *
     * [100, 80, 60]
     *
     * Good
     *
     * If 70 arrives:
     *
     * Remove 60
     *
     * Stack:
     *
     * [100, 80]
     *
     * Then push 70
     *
     * Stack:
     *
     * [100, 80, 70]
     *
     * Decreasing order maintained.
     *
     * ---------------------------------------------------------
     *
     * Steps:
     *
     * 1. Add current price to list.
     *
     * 2. Remove all smaller or equal prices:
     *
     * while(top <= currentPrice)
     * pop()
     *
     * 3. After popping:
     *
     * Top = Previous Greater Price Index
     *
     * 4. If stack becomes empty:
     *
     * Previous Greater Index = -1
     *
     * 5. Calculate:
     *
     * Span =
     * Current Index - Previous Greater Index
     *
     * 6. Push current index into stack.
     *
     * ---------------------------------------------------------
     *
     * Dry Run:
     *
     * Prices:
     *
     * [100,80,60,70,60,75,85]
     *
     * Day 0:
     * Price = 100
     *
     * Stack = []
     *
     * Previous Greater Index = -1
     *
     * Span = 0 - (-1) = 1
     *
     * Push 0
     *
     * Stack = [0]
     *
     * ---------------------------------------------------------
     *
     * Day 1:
     * Price = 80
     *
     * Top Price = 100
     *
     * No pop
     *
     * Previous Greater Index = 0
     *
     * Span = 1 - 0 = 1
     *
     * Push 1
     *
     * Stack = [0,1]
     *
     * ---------------------------------------------------------
     *
     * Day 6:
     * Price = 85
     *
     * Pop:
     *
     * 75
     * 60
     * 70
     * 60
     * 80
     *
     * Stop at:
     *
     * 100
     *
     * Previous Greater Index = 0
     *
     * Current Index = 6
     *
     * Span = 6 - 0 = 6
     *
     * ---------------------------------------------------------
     *
     * Why It Works:
     *
     * The stack always stores candidates that can become
     * Previous Greater Elements for future prices.
     *
     * Smaller prices become useless once a larger price
     * appears and are removed permanently.
     *
     * ---------------------------------------------------------
     *
     * Pattern Insight:
     *
     * Whenever a problem asks:
     *
     * - Previous Greater Element
     * - Previous Smaller Element
     * - Next Greater Element
     * - Next Smaller Element
     * - Span of Elements
     *
     * Think:
     *
     * Monotonic Stack
     *
     * ---------------------------------------------------------
     *
     * Common Interview Clue:
     *
     * If you are repeatedly searching left/right
     * for the first greater/smaller element,
     * a Monotonic Stack is probably the optimal solution.
     *
     * ---------------------------------------------------------
     *
     * Mistakes I Made:
     *
     * - Initially thought of checking all previous prices.
     * - Didn't realize span depends only on the nearest
     * previous greater element.
     * - Missed that indices are more useful than values.
     * - Forgot why smaller elements can be safely removed.
     *
     * ---------------------------------------------------------
     *
     * Time Complexity:
     *
     * Amortized O(1) per next() call
     *
     * Reason:
     * Every index is pushed once and popped at most once.
     *
     * Across n operations:
     *
     * O(n)
     *
     * ---------------------------------------------------------
     *
     * Space Complexity:
     *
     * O(n)
     */

    static class StockSpanner {

        Stack<Integer> stack;
        ArrayList<Integer> list;

        public StockSpanner() {
            stack = new Stack<>();
            list = new ArrayList<>();
        }

        public int next(int price) {

            list.add(price);

            while (!stack.isEmpty()
                    && list.get(stack.peek()) <= price) {
                stack.pop();
            }

            int previousGreaterIdx = stack.isEmpty() ? -1 : stack.peek();

            int currentIdx = list.size() - 1;

            int span = currentIdx - previousGreaterIdx;

            stack.push(currentIdx);

            return span;
        }
    }

    public static void main(String[] args) {

        StockSpanner stockSpanner = new StockSpanner();

        System.out.println(stockSpanner.next(100)); // 1
        System.out.println(stockSpanner.next(80)); // 1
        System.out.println(stockSpanner.next(60)); // 1
        System.out.println(stockSpanner.next(70)); // 2
        System.out.println(stockSpanner.next(60)); // 1
        System.out.println(stockSpanner.next(75)); // 4
        System.out.println(stockSpanner.next(85)); // 6
    }
}