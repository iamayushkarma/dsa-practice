package patterns.queue;

import java.util.Arrays;

class MyCircularQueue {

    /**
     * Problem : Design Circular Queue
     * LeetCode : 622
     * Link : https://leetcode.com/problems/design-circular-queue/
     * Pattern : Circular Queue, Array, Data Structure Design
     * Difficulty : Medium
     * Date Solved : 26-10-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Implement a circular queue using a fixed-size array.
     *
     * Maintain four variables:
     * 1. front - index of the first element.
     * 2. rear - index of the last element.
     * 3. count - number of elements currently in the queue.
     * 4. size - maximum capacity of the queue.
     *
     * EnQueue:
     * If the queue is full, return false.
     * Otherwise, move rear circularly using (rear + 1) % size,
     * insert the value, and increment count.
     *
     * DeQueue:
     * If the queue is empty, return false.
     * Otherwise, move front circularly using (front + 1) % size
     * and decrement count.
     *
     * Front:
     * Return the element at the front index.
     * If the queue is empty, return -1.
     *
     * Rear:
     * Return the element at the rear index.
     * If the queue is empty, return -1.
     *
     * IsEmpty:
     * The queue is empty when count == 0.
     *
     * IsFull:
     * The queue is full when count == size.
     *
     * Why It Works:
     * The modulo operator allows front and rear to wrap around
     * to index 0 after reaching the last array position.
     * The count variable distinguishes between an empty queue
     * and a full queue without requiring extra array space.
     *
     * Pattern Insight:
     * A circular queue reuses array positions freed by dequeue
     * operations instead of shifting elements.
     * Using (index + 1) % size provides circular movement,
     * while count tracks the current number of stored elements.
     *
     * Mistake I Made:
     * Initially, the conditions for isEmpty() and isFull()
     * were used incorrectly in enQueue() and deQueue().
     * Also, -1 was assigned instead of the incoming value.
     *
     * Pitfalls:
     * 1. enQueue() must check isFull(), not isEmpty().
     * 2. deQueue() must check isEmpty(), not isFull().
     * 3. Store value at circularQueue[rear].
     * 4. Update front and rear using modulo arithmetic.
     * 5. Rear() should return -1 only when the queue is empty,
     * not when the queue is full.
     *
     * Time Complexity:
     * enQueue() : O(1)
     * deQueue() : O(1)
     * Front() : O(1)
     * Rear() : O(1)
     * isEmpty() : O(1)
     * isFull() : O(1)
     *
     * Space Complexity : O(k)
     * k = maximum capacity of the circular queue.
     */

    int[] circularQueue;
    int count = 0;
    int front = 0;
    int rear = -1;
    int size;

    public MyCircularQueue(int k) {
        circularQueue = new int[k];
        size = k;
    }

    public boolean enQueue(int value) {
        if (isFull())
            return false;

        rear = (rear + 1) % size;
        circularQueue[rear] = value;
        count++;

        return true;
    }

    public boolean deQueue() {
        if (isEmpty())
            return false;

        front = (front + 1) % size;
        count--;

        return true;
    }

    public int Front() {
        if (isEmpty())
            return -1;

        return circularQueue[front];
    }

    public int Rear() {
        if (isEmpty())
            return -1;

        return circularQueue[rear];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }
}
