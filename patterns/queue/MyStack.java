package patterns.queue;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    /**
     * Problem : Implement Stack using Queues
     * LeetCode : 225
     * Link : https://leetcode.com/problems/implement-stack-using-queues/
     * Pattern : Stack, Queue, Data Structure Design
     * Difficulty : Easy
     * Date Solved : 26-10-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Use a single queue to implement a stack.
     *
     * push(x):
     * Insert the element at the rear of the queue.
     *
     * pop():
     * Rotate the first n-1 elements from the front to the rear.
     * The last inserted element reaches the front and can be removed.
     *
     * top():
     * Rotate the first n-1 elements to the rear.
     * Read the front element using peek(), then move it to the rear
     * to restore the original queue order.
     *
     * empty():
     * Check whether the queue contains any elements.
     *
     * Why It Works:
     * A queue follows FIFO, whereas a stack follows LIFO.
     * Rotating the queue brings the most recently inserted element
     * to the front, allowing stack operations to be simulated.
     *
     * Pattern Insight:
     * When implementing one data structure using another, identify
     * which operations violate the required ordering and use rotations
     * to maintain the expected behavior.
     *
     * Mistake I Made:
     * No specific mistake was reported.
     * Pitfall: Rotate exactly n-1 elements in pop() and top().
     * Rotating n elements would change the intended behavior.
     *
     * Time Complexity:
     * push() : O(1)
     * pop() : O(n)
     * top() : O(n)
     * empty() : O(1)
     *
     * Space Complexity : O(n)
     */

    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
    }

    public int pop() {
        int n = queue.size();

        for (int i = 0; i < n - 1; i++) {
            queue.add(queue.remove());
        }

        return queue.remove();
    }

    public int top() {
        int n = queue.size();

        for (int i = 0; i < n - 1; i++) {
            queue.add(queue.remove());
        }

        int el = queue.peek();
        queue.add(queue.remove());

        return el;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
