package patterns.stack;

import java.util.Stack;

public class MinStack {
    /*
     * Problem : Min Stack
     * LeetCode : #155
     * Link: https://leetcode.com/problems/min-stack/
     * Pattern : Stack + Auxiliary Stack
     * Difficulty : Medium
     * Date Solved: 04-Jun-2026
     * Revision : [✅] Day3 [✅] Day7 [ ] Day14
     *
     * My Approach:
     * Initially thought about finding the minimum element
     * whenever getMin() is called by traversing the stack.
     *
     * But that would make getMin() O(n), which violates
     * the problem requirement.
     *
     * Optimal Approach:
     * Use two stacks:
     * 1. Main Stack -> stores all elements.
     * 2. Min Stack -> stores current minimum elements.
     *
     * Steps:
     * 1. Push value into main stack.
     * 2. If min stack is empty or current value <= min,
     * push it into min stack.
     * 3. During pop:
     * - Remove element from main stack.
     * - If popped element equals current minimum,
     * remove it from min stack too.
     * 4. top() returns top of main stack.
     * 5. getMin() returns top of min stack.
     *
     * Why it works:
     * Min stack always keeps track of the minimum element
     * available in the main stack.
     *
     * Whenever the current minimum is removed,
     * the previous minimum automatically becomes available
     * on top of the min stack.
     *
     * Pattern Insight:
     * When a stack problem asks for:
     * - Current minimum
     * - Current maximum
     * - Additional information about stack state
     *
     * Think about maintaining an auxiliary stack.
     *
     * Mistake I Made:
     * - Considered scanning stack for minimum each time.
     * - Forgot duplicate minimum values must also be stored.
     * - Used '>' instead of '>=' while pushing into min stack.
     *
     * Time Complexity:
     * push() -> O(1)
     * pop() -> O(1)
     * top() -> O(1)
     * getMin() -> O(1)
     *
     * Space Complexity: O(n)
     */

    // Design a stack that supports push, pop, top,
    // and retrieving the minimum element in constant time.

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);

        if (minStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        }
    }

    public void pop() {
        int popValue = stack.pop();

        if (minStack.peek().equals(popValue)) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println("Minimum: " + minStack.getMin()); // -3

        minStack.pop();

        System.out.println("Top: " + minStack.top()); // 0
        System.out.println("Minimum: " + minStack.getMin()); // -2
    }
}