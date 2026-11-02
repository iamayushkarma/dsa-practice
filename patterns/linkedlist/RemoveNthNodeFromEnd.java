package patterns.linkedlist;

public class RemoveNthNodeFromEnd {

    /*
     * Problem : Remove Nth Node From End of List
     * LeetCode : #19
     * Link: https://leetcode.com/problems/remove-nth-node-from-end-of-list/
     * Pattern : Linked List / Two Pointers
     * Difficulty : Medium
     * Date Solved: 02-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Use two pointers starting from a dummy node before the head.
     * Move the end pointer n + 1 steps ahead.
     * Move both pointers until end reaches null.
     * The st pointer will be before the node to remove.
     *
     * Optimal Approach:
     * Use a dummy node and two pointers to locate the target node
     * in one traversal. Update st.next to skip the target node.
     *
     * Pattern Insight:
     * Two Pointers with a Fixed Gap.
     * Maintaining a gap of n + 1 nodes positions st before the
     * nth node from the end when end reaches null.
     *
     * Mistake I Made:
     * The earlier approach did not handle removing the head correctly
     * and did not move the start pointer in the traversal loop.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    // Given the head of a linked list, remove the nth node from
    // the end of the list and return its head.

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0, head);
        ListNode st = temp;
        ListNode end = temp;

        for (int i = 0; i <= n; i++) {
            end = end.next;
        }

        while (end != null) {
            st = st.next;
            end = end.next;
        }

        st.next = st.next.next;

        return temp.next;
    }

    public static void main(String[] args) {

        // Test case 1:
        // Input: head = [1, 2, 3, 4, 5], n = 2
        // Expected: [1, 2, 3, 5]

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        ListNode result1 = removeNthFromEnd(head1, 2);

        assert result1.val == 1;
        assert result1.next.val == 2;
        assert result1.next.next.val == 3;
        assert result1.next.next.next.val == 5;
        assert result1.next.next.next.next == null;

        // Test case 2:
        // Input: head = [1], n = 1
        // Expected: []

        ListNode head2 = new ListNode(1);

        ListNode result2 = removeNthFromEnd(head2, 1);

        assert result2 == null;

        // Test case 3:
        // Input: head = [1, 2], n = 2
        // Expected: [2]

        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);

        ListNode result3 = removeNthFromEnd(head3, 2);

        assert result3.val == 2;
        assert result3.next == null;
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