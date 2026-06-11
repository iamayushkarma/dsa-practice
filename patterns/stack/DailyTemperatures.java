package patterns.monotonic_stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    /*
     * Problem : Daily Temperatures
     * LeetCode : #739
     * Link: https://leetcode.com/problems/daily-temperatures/
     * Pattern : Monotonic Decreasing Stack
     * Difficulty : Medium
     * Date Solved: 04-Jun-2026
     * Revision : [✅] Day3 [✅] Day7 [ ] Day14
     *
     * My Approach:
     * Initially thought about checking every future day
     * for each temperature to find the next warmer day.
     *
     * But that would require nested loops and result
     * in O(n²) time complexity.
     *
     * Optimal Approach:
     * Use a Monotonic Decreasing Stack.
     *
     * Store:
     * [temperature, index]
     *
     * Steps:
     * 1. Traverse temperatures from left to right.
     * 2. While current temperature is greater than
     * stack top temperature:
     * - Pop stack.
     * - Calculate waiting days.
     * - Store answer.
     * 3. Push current temperature and index.
     * 4. Remaining elements in stack have no warmer
     * temperature ahead, so their answer remains 0.
     *
     * Why it works:
     * The stack maintains temperatures in decreasing order.
     *
     * Whenever a warmer temperature is found,
     * we immediately know the answer for all smaller
     * temperatures waiting in the stack.
     *
     * Pattern Insight:
     * Whenever a problem asks for:
     * - Next Greater Element
     * - Next Warmer Day
     * - First Larger Value on Right
     * - Future Greater Element
     *
     * Think about using a Monotonic Decreasing Stack.
     *
     * Mistake I Made:
     * - Started with brute force O(n²).
     * - Forgot to store index along with temperature.
     * - Confused temperature difference with day difference.
     * - Tried comparing all future elements unnecessarily.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    // Given an array of daily temperatures,
    // return how many days must be waited
    // until a warmer temperature occurs.

    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        Stack<int[]> stack = new Stack<>(); // int[] -> [temperature, index]

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                    temperatures[i] > stack.peek()[0]) {

                int[] prev = stack.pop();
                int prevIndex = prev[1];

                res[prevIndex] = i - prevIndex;
            }

            stack.push(new int[] { temperatures[i], i });
        }

        return res;
    }

    public static void main(String[] args) {

        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };

        System.out.println(
                "Daily Temperatures: "
                        + Arrays.toString(dailyTemperatures(temperatures)));
    }
}