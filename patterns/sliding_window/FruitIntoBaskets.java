package patterns.sliding_window;

import java.util.*;

public class FruitIntoBaskets {
    /*
     * Problem : Fruit Into Baskets
     * LeetCode : #904
     * Link:
     * https://leetcode.com/problems/fruit-into-baskets/
     * Pattern : Sliding Window / Hashing
     * Difficulty : Medium
     * Date Solved: 29-May-2026
     * Revision : [✅] Day3 [✅] Day7 [ ] Day14
     *
     * My Approach:
     * Used sliding window with HashMap.
     * - Expand window using we
     * - Store fruit frequencies in HashMap
     * - If window contains more than 2 fruit types,
     * shrink window from ws until only 2 types remain
     * - Track maximum window size during the process
     *
     * Why It Works:
     * We can only keep 2 different fruit types in our baskets.
     * HashMap helps track how many fruit types are currently
     * inside the window.
     *
     * Pattern Insight:
     * This is a variable size sliding window problem.
     * Key idea: maintain a valid window containing
     * at most 2 distinct fruit types.
     * If the number of fruit types becomes greater than 2,
     * shrink the window until it becomes valid again.
     *
     * Mistake I Made:
     * - Initially focused on window length instead of
     * number of distinct fruit types.
     * - Tried tracking baskets manually instead of using
     * HashMap size.
     * - Forgot that baskets represent fruit types,
     * not individual fruits.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * (HashMap stores at most 3 fruit types at any time)
     */

    // Given an array representing fruit types on trees arranged in a row, find the
    // maximum number of fruits that can be collected from a continuous sequence of
    // trees while carrying fruits in only two baskets, where each basket can hold
    // only one type of fruit.
    public static int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max_fruit = 0;
        int ws = 0;
        int fruit = 0;
        for (int we = 0; we < fruits.length; we++) {
            map.put(fruits[we], map.getOrDefault(fruits[we], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[ws], map.get(fruits[ws]) - 1);
                if (map.get(fruits[ws]) == 0) {
                    map.remove(fruits[ws]);
                }
                ws++;
            }

            max_fruit = Math.max(max_fruit, we - ws + 1);
        }
        return max_fruit;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 2, 2 };
        System.out.println("Total max fruits that can be picked: " + totalFruit(arr));
    }
}