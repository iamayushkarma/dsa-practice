package patterns.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    /*
     * Problem : Next Greater Element II
     * LeetCode : #503
     * Link: https://leetcode.com/problems/next-greater-element-ii/
     * Pattern : Monotonic Decreasing Stack + Circular Array
     * Difficulty : Medium
     * Date Solved: 10-Jun-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Initial Approach:
     * Tried solving it exactly like the standard
     * Next Greater Element problem.
     *
     * Traversed from right to left and maintained
     * a Monotonic Decreasing Stack.
     *
     * However, that only works for a normal array.
     *
     * This problem introduces a circular array,
     * meaning after reaching the last element,
     * traversal continues again from the beginning.
     *
     * Because of this, elements may find their
     * Next Greater Element on the left side
     * after wrapping around.
     *
     * Example:
     *
     * nums = [1,2,1]
     *
     * For the last 1:
     * Answer = 2
     *
     * A single traversal cannot discover it.
     *
     * Optimal Approach:
     * Simulate traversing the circular array
     * by iterating from:
     *
     * 2*n - 1 → 0
     *
     * Use:
     *
     * idx = i % n
     *
     * to revisit the same array twice.
     *
     * The first pass builds the stack.
     * The second pass computes answers.
     *
     * Steps:
     * 1. Traverse from (2*n - 1) to 0.
     * 2. Convert virtual index into actual index:
     *
     * idx = i % n
     *
     * 3. Remove all elements smaller than or equal
     * to the current element.
     * 4. Stack top becomes the Next Greater Element.
     * 5. Store answer only when i < n.
     * 6. Push current element into the stack.
     *
     * Why it works:
     * The stack always contains valid candidates
     * for the Next Greater Element.
     *
     * Traversing twice ensures every element
     * can see all elements to its right,
     * including those reached after wrapping.
     *
     * Pattern Insight:
     * Whenever you see:
     * - Circular Array
     * - Next Greater Element
     * - Next Smaller Element
     * - Nearest Greater/Smaller
     *
     * Think:
     *
     * Traverse 2*n times
     * Use i % n
     * Apply Monotonic Stack
     *
     * Mistakes I Made:
     * - Tried solving with a single traversal.
     * - Special-cased only the last element.
     * - Forgot every element can wrap around.
     * - Initially overcomplicated circular handling.
     *
     * Key Observation:
     *
     * Normal NGE:
     * Traverse n elements.
     *
     * Circular NGE:
     * Traverse 2*n elements.
     *
     * Time Complexity: O(n)
     *
     * Every element is pushed once
     * and popped at most once.
     *
     * Space Complexity: O(n)
     *
     * Stack stores at most n elements.
     */

    // Given a circular integer array nums,
    // return the Next Greater Element for every index.
    //
    // The Next Greater Element of nums[i]
    // is the first greater element encountered
    // while moving right circularly.
    //
    // If none exists, return -1.

    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;
        int[] result = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {

            int idx = i % n;

            while (!stack.isEmpty() &&
                    stack.peek() <= nums[idx]) {
                stack.pop();
            }

            if (i < n) {
                result[idx] = stack.isEmpty() ? -1 : stack.peek();
            }

            stack.push(nums[idx]);
        }

        return result;
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 1 };

        System.out.println(
                "Next Greater Elements: "
                        + Arrays.toString(nextGreaterElements(nums)));
    }
}