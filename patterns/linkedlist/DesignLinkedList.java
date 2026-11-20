package patterns.linkedlist;

public class DesignLinkedList {

    /*
     * Problem : Design Linked List
     * LeetCode : #707
     * Link: https://leetcode.com/problems/design-linked-list/
     * Pattern : Singly Linked List / Pointer Manipulation
     * Difficulty : Medium
     * Date Solved: 20-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - Maintain a head pointer and size variable.
     * - Use traversal to access nodes by index.
     * - Handle head, tail, and middle insertion separately.
     * - Update size after every successful insertion or deletion.
     *
     * Optimal Approach:
     * - Singly linked list with indexed traversal.
     *
     * Pattern Insight:
     * - Maintain accurate size to validate indices.
     * - For insertion and deletion, reach the previous node.
     * - Handle index 0 separately because it changes the head.
     *
     * Mistake I Made:
     * - Initially confused the Node constructor with the MyLinkedList constructor.
     *
     * Time Complexity:
     * - get: O(n)
     * - addAtHead: O(1)
     * - addAtTail: O(n)
     * - addAtIndex: O(n)
     * - deleteAtIndex: O(n)
     *
     * Space Complexity: O(n)
     */

    /*
     * Problem Statement:
     * Design a singly linked list with the following operations:
     *
     * get(index): Return the value at the given index.
     * addAtHead(val): Insert a node at the beginning.
     * addAtTail(val): Insert a node at the end.
     * addAtIndex(index, val): Insert before the given index.
     * deleteAtIndex(index): Delete the node at the given index.
     *
     * If index is greater than the list size, insertion is ignored.
     * If index equals the list size, insert at the tail.
     * Invalid get and delete operations are ignored.
     */

    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    Node head = null;
    int size = 0;

    public DesignLinkedList() {
        head = null;
    }

    public int get(int index) {
        if (index >= size || index < 0)
            return -1;

        Node temp = head;

        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp.val;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        if (head == null) {
            addAtHead(val);
            return;
        }

        Node temp = head;

        while (temp.next != null)
            temp = temp.next;

        Node newNode = new Node(val);
        temp.next = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size)
            return;

        if (index == 0) {
            addAtHead(val);
            return;
        }

        if (index == size) {
            addAtTail(val);
            return;
        }

        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(val);
        newNode.next = temp.next;
        temp.next = newNode;

        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size || index < 0)
            return;

        if (index == 0) {
            head = head.next;
            size--;
            return;
        }

        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }

    public static void main(String[] args) {

        DesignLinkedList list = new DesignLinkedList();

        // Test Case 1: Add at head
        list.addAtHead(1);
        assert list.get(0) == 1;

        // Test Case 2: Add at tail
        list.addAtTail(3);
        assert list.get(1) == 3;

        // Test Case 3: Add at index
        list.addAtIndex(1, 2);
        assert list.get(1) == 2;
        assert list.get(2) == 3;

        // Test Case 4: Delete at index
        list.deleteAtIndex(1);
        assert list.get(1) == 3;
        assert list.get(2) == -1;

        // Test Case 5: Invalid indices
        assert list.get(-1) == -1;
        assert list.get(10) == -1;

        // Test Case 6: Delete head
        list.deleteAtIndex(0);
        assert list.get(0) == 3;

        // Test Case 7: Delete last node
        list.deleteAtIndex(0);
        assert list.get(0) == -1;

        System.out.println("All test cases passed!");
    }
}