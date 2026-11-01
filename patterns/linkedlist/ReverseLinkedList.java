package patterns.linkedlist;

public class ReverseLinkedList {

    /*
     * Problem : Reverse Linked List
     * LeetCode : #206
     * Link: https://leetcode.com/problems/reverse-linked-list/
     * Pattern : Linked List / Iterative Reversal
     * Difficulty : Easy
     * Date Solved: 01-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Use three pointers: current, prev, and nextNode.
     * Store the next node before reversing the current node's pointer.
     * Move prev and current forward until current becomes null.
     *
     * Optimal Approach:
     * Iteratively reverse the links using three pointers.
     * Return prev as the new head after all links are reversed.
     *
     * Pattern Insight:
     * Linked List Pointer Reversal.
     * Save the next node before changing current.next to avoid
     * losing access to the remaining list.
     *
     * Mistake I Made:
     * No specific mistake reported.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    // Given the head of a singly linked list, reverse the list
    // and return the new head.

    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            ListNode nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }

    public static void main(String[] args) {

        // Test case 1: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        ListNode result1 = reverseList(head1);

        assert result1.val == 5;
        assert result1.next.val == 4;
        assert result1.next.next.val == 3;
        assert result1.next.next.next.val == 2;
        assert result1.next.next.next.next.val == 1;
        assert result1.next.next.next.next.next == null;

        // Test case 2: 1 -> 2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        ListNode result2 = reverseList(head2);

        assert result2.val == 2;
        assert result2.next.val == 1;
        assert result2.next.next == null;

        // Test case 3: Empty list
        ListNode result3 = reverseList(null);

        assert result3 == null;

        // Test case 4: Single node
        ListNode head4 = new ListNode(7);

        ListNode result4 = reverseList(head4);

        assert result4.val == 7;
        assert result4.next == null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}