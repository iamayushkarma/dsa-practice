package patterns.linkedlist;

public class ReorderList {

    /*
     * Problem : Reorder List
     * LeetCode : #143
     * Link: https://leetcode.com/problems/reorder-list/
     * Pattern : Linked List / Fast and Slow Pointers / Reversal
     * Difficulty : Medium
     * Date Solved: 03-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Find the middle of the linked list using slow and fast pointers.
     * Reverse the second half of the list.
     * Split the list into two halves and merge them alternately.
     *
     * Optimal Approach:
     * Use slow and fast pointers to find the middle.
     * Reverse the second half in-place.
     * Merge both halves by alternating nodes.
     * This avoids creating additional lists.
     *
     * Pattern Insight:
     * Fast and Slow Pointers + Linked List Reversal + Two Pointers.
     * The list can be reordered by splitting it at the middle,
     * reversing the second half, and merging the halves.
     *
     * Mistake I Made:
     * No specific mistake reported.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    // Given a linked list L0 -> L1 -> ... -> Ln,
    // reorder it as L0 -> Ln -> L1 -> Ln-1 -> ...

    public static void reorderList(ListNode head) {
        if (head == null)
            return;

        ListNode slow = head;
        ListNode fast = head;

        // Find the middle of the list
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half
        ListNode point = reverse(slow.next);
        slow.next = null;

        // Merge both halves alternately
        fast = head;

        while (point != null) {
            ListNode temp1 = fast.next;
            ListNode temp2 = point.next;

            fast.next = point;
            point.next = temp1;

            fast = temp1;
            point = temp2;
        }
    }

    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    public static void main(String[] args) {

        // Test case 1:
        // Input: [1, 2, 3, 4]
        // Expected: [1, 4, 2, 3]

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        reorderList(head1);

        assert head1.val == 1;
        assert head1.next.val == 4;
        assert head1.next.next.val == 2;
        assert head1.next.next.next.val == 3;
        assert head1.next.next.next.next == null;

        // Test case 2:
        // Input: [1, 2, 3, 4, 5]
        // Expected: [1, 5, 2, 4, 3]

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        reorderList(head2);

        assert head2.val == 1;
        assert head2.next.val == 5;
        assert head2.next.next.val == 2;
        assert head2.next.next.next.val == 4;
        assert head2.next.next.next.next.val == 3;
        assert head2.next.next.next.next.next == null;

        // Test case 3:
        // Input: [1]
        // Expected: [1]

        ListNode head3 = new ListNode(1);

        reorderList(head3);

        assert head3.val == 1;
        assert head3.next == null;

        // Test case 4:
        // Input: []
        // Expected: []

        reorderList(null);
    }

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
}