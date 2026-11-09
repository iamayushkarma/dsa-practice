package patterns.linkedlist;

public class ReverseLinkedListII {

    /*
     * Problem : Reverse Linked List II
     * LeetCode : #92
     * Link: https://leetcode.com/problems/reverse-linked-list-ii/
     * Pattern : Dummy Node + Iterative Reversal
     * Difficulty : Medium
     * Date Solved: 09-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Use a dummy node to handle reversal starting from position 1.
     * Traverse to the node immediately before the left position.
     * Reverse the sublist between left and right using iterative
     * pointer manipulation.
     * Reconnect the reversed sublist with the original prefix and suffix.
     *
     * Optimal Approach:
     * Iterative in-place reversal using a dummy node.
     * Reverse exactly (right - left + 1) nodes.
     * Reconnect the previous node to the new head of the reversed
     * sublist and the original sublist head to the remaining list.
     *
     * Pattern Insight:
     * When reversing a sublist, maintain three important connections:
     * 1. Previous node -> New head of reversed sublist.
     * 2. Original head of sublist -> Remaining unreversed list.
     * 3. Dummy node -> Original head when reversal starts at position 1.
     *
     * Mistake I Made:
     * Initially confused node values with positions and struggled
     * with reconnecting the reversed sublist to the remaining list.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    /*
     * Problem Statement:
     * Given the head of a singly linked list and two integers left
     * and right, reverse the nodes of the list from position left
     * to position right (1-indexed).
     *
     * Return the modified linked list.
     */

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode DummyNode = new ListNode(0, head);

        ListNode leftPrev = DummyNode;
        ListNode curr = head;

        // Move to the node immediately before the left position.
        for (int i = 0; i < left - 1; i++) {
            leftPrev = curr;
            curr = curr.next;
        }

        // Reverse the sublist between left and right.
        ListNode prev = null;

        for (int i = 0; i < right - left + 1; i++) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // Reconnect the reversed sublist.
        leftPrev.next.next = curr;
        leftPrev.next = prev;

        return DummyNode.next;
    }

    // Helper class for standalone execution.
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

        // Test Case 1: Reverse middle sublist.
        ListNode head1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        ListNode result1 = reverseBetween(head1, 2, 4);
        assertValues(result1, 1, 4, 3, 2, 5);

        // Test Case 2: Reverse starting from head.
        ListNode head2 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));

        ListNode result2 = reverseBetween(head2, 1, 2);
        assertValues(result2, 2, 1, 3, 4);

        // Test Case 3: Reverse entire linked list.
        ListNode head3 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3)));

        ListNode result3 = reverseBetween(head3, 1, 3);
        assertValues(result3, 3, 2, 1);

        // Test Case 4: left == right.
        ListNode head4 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3)));

        ListNode result4 = reverseBetween(head4, 2, 2);
        assertValues(result4, 1, 2, 3);

        System.out.println("All test cases passed!");
    }
}