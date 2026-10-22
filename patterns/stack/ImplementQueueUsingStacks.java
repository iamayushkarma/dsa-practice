package patterns.stack;

import java.util.Stack;

public class ImplementQueueUsingStacks {

    /*
     * Problem : Implement Queue using Stacks
     * LeetCode : 232
     * Link: https://leetcode.com/problems/implement-queue-using-stacks/
     * Pattern : Stack (Two Stacks to Simulate a Queue)
     * Difficulty : Easy
     * Date Solved: 22-10-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * A queue follows FIFO (First In, First Out), whereas a stack follows
     * LIFO (Last In, First Out).
     *
     * To implement a queue using stacks, use two stacks:
     * 1. mainStack: stores newly inserted elements.
     * 2. helperStack: provides elements in queue order.
     *
     * Operations:
     *
     * 1. push(x):
     * Push the new element directly into mainStack.
     *
     * 2. pop():
     * Call peek() to ensure helperStack contains elements in queue order.
     * Then remove and return the top element of helperStack.
     *
     * 3. peek():
     * If helperStack is empty, transfer all elements from mainStack
     * to helperStack.
     *
     * Reversing the elements this way makes the oldest inserted
     * element available at the top of helperStack.
     *
     * Return the top element without removing it.
     *
     * 4. empty():
     * Return true only when both stacks are empty.
     *
     * Pattern Insight:
     * Two stacks can simulate a queue because transferring elements from
     * one stack to another reverses their order.
     *
     * Elements are transferred only when helperStack is empty.
     * Therefore, each element is pushed into and popped from each stack
     * at most once during its lifetime.
     *
     * This gives amortized O(1) time for push(), pop(), and peek().
     *
     * Mistake I Made:
     * No specific mistake was reported in the original implementation.
     *
     * Important Pitfalls:
     * 1. Transfer elements only when helperStack is empty.
     * Transferring every time would disrupt the queue order.
     * 2. Check both stacks in empty().
     * 3. LeetCode guarantees that pop() and peek() are called on a
     * non-empty queue, so no empty-queue handling is required here.
     *
     * Time Complexity:
     * push() : O(1)
     * pop() : Amortized O(1), worst-case O(n)
     * peek() : Amortized O(1), worst-case O(n)
     * empty() : O(1)
     *
     * Space Complexity: O(n)
     * Both stacks together store all elements in the queue.
     */

    Stack<Integer> mainStack;
    Stack<Integer> helperStack;

    public ImplementQueueUsingStacks() {
        mainStack = new Stack<>();
        helperStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);
    }

    public int pop() {
        peek();
        return helperStack.pop();
    }

    public int peek() {
        if (helperStack.isEmpty()) {
            while (!mainStack.isEmpty()) {
                helperStack.push(mainStack.pop());
            }
        }

        return helperStack.peek();
    }

    public boolean empty() {
        return helperStack.isEmpty() && mainStack.isEmpty();
    }

    public static void main(String[] args) {

        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();

        queue.push(1);
        queue.push(2);

        System.out.println(queue.peek()); // Output: 1
        System.out.println(queue.pop()); // Output: 1
        System.out.println(queue.empty()); // Output: false
    }
}