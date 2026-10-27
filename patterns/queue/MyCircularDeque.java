package patterns.queue;

public class MyCircularDeque {

    /*
     * Problem : Design Circular Deque
     * LeetCode : 641
     * Link: https://leetcode.com/problems/design-circular-deque/
     * Pattern : Circular Array / Deque
     * Difficulty : Medium
     * Date Solved: 27-10-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Use a fixed-size array to implement a circular deque.
     * Maintain front, rear, size, and count to track the first
     * element, last element, capacity, and number of elements.
     * Use modulo arithmetic to wrap indices around the array.
     *
     * Pattern Insight:
     * Circular Array / Deque
     *
     * Mistake I Made:
     * Declared local variables inside the constructor instead of
     * initializing the instance fields, leaving the actual fields
     * with their default values.
     *
     * Time Complexity: O(1) for all operations
     * Space Complexity: O(k)
     */

    // Design a double-ended queue supporting insertion and deletion
    // from both ends. Return -1 when getFront() or getRear() is called
    // on an empty deque.
    // - Optimal Approach

    int[] deque;
    int front;
    int rear;
    int size;
    int count;

    public MyCircularDeque(int k) {
        deque = new int[k];
        front = 0;
        rear = k - 1;
        size = k;
        count = 0;
    }

    public boolean insertFront(int value) {
        if (isFull())
            return false;

        front = (front - 1 + size) % size;
        deque[front] = value;
        count++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull())
            return false;

        rear = (rear + 1) % size;
        deque[rear] = value;
        count++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty())
            return false;

        front = (front + 1) % size;
        count--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty())
            return false;

        rear = (rear - 1 + size) % size;
        count--;
        return true;
    }

    public int getFront() {
        if (isEmpty())
            return -1;
        return deque[front];
    }

    public int getRear() {
        if (isEmpty())
            return -1;
        return deque[rear];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }
}
