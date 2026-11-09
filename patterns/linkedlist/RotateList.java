package patterns.linkedlist;

public class RotateList {

    /*
     * Problem : Rotate List
     * LeetCode : #61
     * Link: https://leetcode.com/problems/rotate-list/
     * Pattern : Linked List + Two Pointers + Circular Connection
     * Difficulty : Medium
     * Date Solved: 09-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * First calculate the length of the linked list and identify
     * the original tail.
     * Use k % size to calculate the effective number of rotations.
     * Find the new tail at position (size - k - 1).
     * Disconnect the list at the new tail and connect the original
     * tail to the original head.
     *
     * Optimal Approach:
     * Find the length and original tail in one traversal.
     * Reduce k using modulo to avoid unnecessary rotations.
     * Locate the new tail, identify the new head, and reconnect
     * the list in O(1) extra space.
     *
     * Pattern Insight:
     * Rotating a linked list right by k positions is equivalent
     * to moving the last k nodes to the beginning.
     *
     * The effective rotations are k % size.
     *
     * The new tail is at index (size - k - 1), using 0-based indexing.
     * The new head is newTail.next.
     *
     * Mistake I Made:
     * Initially forgot to handle k % size == 0.
     * This caused the algorithm to return null when k was a
     * multiple of the linked-list length.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    /*
     * Problem Statement:
     * Given the head of a linked list, rotate the list to the right
     * by k places and return the modified linked list.
     */

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0)
            return head;

        int size = 1;
        ListNode temp = head;

        // Calculate linked-list size and find original tail.
        while (temp.next != null) {
            temp = temp.next;
            size++;
        }

        ListNode tail = temp;

        // Calculate effective rotations.
        k = k % size;

        if (k == 0)
            return head;

        // Find the new tail.
        temp = head;

        for (int i = 0; i < size - k - 1; i++)
            temp = temp.next;

        ListNode curr = temp;

        // Reconnect the rotated list.
        ListNode newHead = curr.next;
        curr.next = null;
        tail.next = head;

        return newHead;
    }

    // Node class for standalone execution.
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    // Helper method to verify linked-list output.
    private static void assertValues(ListNode head, int... expected) {

        ListNode curr = head;

        for (int value : expected) {
            assert curr != null : "List ended unexpectedly";

            assert curr.val == value : "Expected " + value + " but got " + curr.val;

            curr = curr.next;
        }

        assert curr == null : "List contains unexpected extra nodes";
    }

    public static void main(String[] args) {

        // Test Case 1: Rotate right by 2.
        ListNode head1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        ListNode result1 = rotateRight(head1, 2);
        assertValues(result1, 4, 5, 1, 2, 3);

        // Test Case 2: k greater than list size.
        ListNode head2 = new ListNode(0,
                new ListNode(1,
                        new ListNode(2)));

        ListNode result2 = rotateRight(head2, 4);
        assertValues(result2, 2, 0, 1);

        // Test Case 3: k is a multiple of list size.
        ListNode head3 = new ListNode(1,
                new ListNode(2));

        ListNode result3 = rotateRight(head3, 2);
        assertValues(result3, 1, 2);

        // Test Case 4: k = 0.
        ListNode head4 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3)));

        ListNode result4 = rotateRight(head4, 0);
        assertValues(result4, 1, 2, 3);

        // Test Case 5: Single-node list.
        ListNode head5 = new ListNode(1);

        ListNode result5 = rotateRight(head5, 5);
        assertValues(result5, 1);

        System.out.println("All test cases passed!");
    }
}