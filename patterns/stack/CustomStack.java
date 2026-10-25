package patterns.stack;

public class CustomStack {

    /*
     * Problem : Design a Stack With Increment Operation
     * LeetCode : 1381
     * Link: https://leetcode.com/problems/design-a-stack-with-increment-operation/
     * Pattern : Stack (Array-Based Implementation)
     * Difficulty : Medium
     * Date Solved: 25-10-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Implement a stack using a fixed-size integer array instead of
     * Java's built-in Stack class.
     *
     * Maintain three variables:
     * 1. arr: stores the stack elements.
     * 2. idx: represents the index where the next element will be inserted.
     * It also represents the current number of elements in the stack.
     * 3. size: stores the maximum capacity of the stack.
     *
     * Operations:
     *
     * 1. CustomStack(maxSize):
     * Initialize the array with maxSize capacity and set size = maxSize.
     *
     * 2. push(x):
     * Insert x at arr[idx] and increment idx if the stack is not full.
     *
     * 3. pop():
     * If the stack is not empty, decrement idx and return arr[idx].
     * Otherwise, return -1.
     *
     * 4. increment(k, val):
     * Increment the bottom k elements by val.
     * Use Math.min(k, idx) to ensure that only existing elements
     * are updated when k exceeds the current stack size.
     *
     * Pattern Insight:
     * An array can implement a stack efficiently using an index that
     * tracks the next insertion position.
     *
     * Since the stack has a fixed capacity, push() must check whether
     * the stack is full before inserting an element.
     *
     * The increment operation affects the bottom k elements, not the
     * top k elements. Therefore, the loop starts at index 0.
     *
     * Mistake I Made:
     * No specific mistake was reported in the original implementation.
     *
     * Important Pitfalls:
     * 1. Use idx < size when checking whether push() is allowed.
     * 2. Decrement idx before accessing the element in pop().
     * 3. Return -1 when pop() is called on an empty stack.
     * 4. Limit k to the current number of elements before incrementing.
     *
     * Time Complexity:
     * Constructor : O(maxSize) for array allocation
     * push() : O(1)
     * pop() : O(1)
     * increment() : O(min(k, idx))
     *
     * Space Complexity: O(maxSize)
     * The array stores up to maxSize elements.
     */

    int[] arr;
    int idx = 0;
    int size = 0;

    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        size = maxSize;
    }

    public void push(int x) {
        if (idx < size) {
            arr[idx++] = x;
        }
    }

    public int pop() {
        if (idx > 0) {
            return arr[--idx];
        }

        return -1;
    }

    public void increment(int k, int val) {
        k = Math.min(k, idx);

        for (int i = 0; i < k; i++) {
            arr[i] += val;
        }
    }

    public static void main(String[] args) {

        CustomStack stack = new CustomStack(3);

        stack.push(1);
        stack.push(2);

        stack.increment(5, 100);

        System.out.println(stack.pop()); // Output: 102
        System.out.println(stack.pop()); // Output: 101
        System.out.println(stack.pop()); // Output: -1
    }
}