package patterns.stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {

    /*
     * Problem : Next Greater Element I
     * LeetCode : #496
     * Link: https://leetcode.com/problems/next-greater-element-i/
     * Pattern : Monotonic Decreasing Stack + HashMap
     * Difficulty : Easy
     * Date Solved: 10-Jun-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Initial Approach:
     * Tried applying the standard Next Greater Element
     * algorithm directly on nums1.
     *
     * But nums1 is only a subset of nums2.
     *
     * The problem asks:
     * For every element in nums1,
     * find its Next Greater Element in nums2.
     *
     * So processing nums1 directly misses information
     * that exists in nums2.
     *
     * Optimal Approach:
     * Precompute Next Greater Element for every value
     * in nums2 using a Monotonic Decreasing Stack.
     *
     * Store:
     *
     * value -> nextGreaterValue
     *
     * inside a HashMap.
     *
     * Then answer each nums1 query in O(1).
     *
     * Steps:
     * 1. Traverse nums2 from right to left.
     * 2. Maintain a decreasing stack.
     * 3. Remove all smaller elements.
     * 4. Stack top becomes the Next Greater Element.
     * 5. Store result in HashMap.
     * 6. Push current element.
     * 7. Traverse nums1 and fetch answers
     * directly from HashMap.
     *
     * Why it works:
     * The stack always contains candidates that are
     * greater than the current element and lie on
     * its right side.
     *
     * After removing all smaller elements:
     *
     * stack.peek()
     *
     * becomes the nearest greater element.
     *
     * Since nums2 contains distinct values,
     * each value can be safely mapped to its NGE.
     *
     * Pattern Insight:
     * Whenever a problem says:
     * - nums1 is a subset of nums2
     * - Multiple queries are asked on nums2
     * - Find next greater/smaller information
     *
     * Think:
     *
     * Preprocess nums2 once
     * Store answers in HashMap
     * Answer queries in O(1)
     *
     * Mistakes I Made:
     * - Iterated over nums1 instead of nums2.
     * - Compared against nums1 while pushing nums2.
     * - Assumed nums1 and nums2 indices matched.
     * - Forgot that NGE must be computed entirely
     * from nums2 first.
     *
     * Optimization:
     * Current solution uses:
     *
     * Stack<Integer>
     *
     * Can be optimized further using:
     *
     * int[] stack = new int[m];
     *
     * to avoid:
     * - Autoboxing
     * - Unboxing
     * - Method call overhead
     *
     * Time Complexity: O(n + m)
     *
     * O(m) -> Build NGE map
     * O(n) -> Answer queries
     *
     * where:
     * n = nums1.length
     * m = nums2.length
     *
     * Space Complexity: O(m)
     *
     * HashMap + Stack
     */

    // nums1 is a subset of nums2. For every element in nums1, find the first
    // greater element appearing on its right in nums2.

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int[] result = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = m - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }

            map.put(
                    nums2[i],
                    stack.isEmpty() ? -1 : stack.peek());

            stack.push(nums2[i]);
        }

        for (int i = 0; i < n; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };

        int[] ans = nextGreaterElement(nums1, nums2);

        System.out.print("Next Greater Elements: ");

        for (int num : ans) {
            System.out.print(num + " ");
        }
    }
}