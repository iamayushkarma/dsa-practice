package patterns.linkedlist;

public class OddEvenLinkedList {

    /*
     * Problem : Odd Even Linked List
     * LeetCode : #328
     * Link: https://leetcode.com/problems/odd-even-linked-list/
     * Pattern : Linked List Manipulation
     * Difficulty : Medium
     * Date Solved: 09-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Maintain separate odd and even pointers.
     * Rearrange the next pointers to group odd-positioned nodes first,
     * followed by even-positioned nodes.
     *
     * Optimal Approach:
     * Use three pointers: odd, even, and evenHead.
     * Connect odd-positioned nodes together and even-positioned nodes
     * together by skipping alternate nodes.
     * Finally, connect the odd list to the even list.
     *
     * Pattern Insight:
     * Odd and even refer to node positions, not node values.
     * Preserve the relative order within both groups.
     * Store evenHead because it marks the beginning of the even list.
     *
     * Mistake I Made:
     * Initially tried creating separate odd and even lists using dummy
     * nodes, but modified the original links incorrectly.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    /*
     * Problem Statement:
     * Given the head of a singly linked list, group all nodes at odd indices
     * together, followed by nodes at even indices.
     * Preserve the relative order within both groups.
     */

    public static ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;

            even.next = odd.next;
            even = even.next;
        }

        odd.next = evenHead;

        return head;
    }

    public static void main(String[] args) {

        // Test Case 1: Odd number of nodes
        ListNode head1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        ListNode result1 = oddEvenList(head1);

        assert result1.val == 1;
        assert result1.next.val == 3;
        assert result1.next.next.val == 5;
        assert result1.next.next.next.val == 2;
        assert result1.next.next.next.next.val == 4;
        assert result1.next.next.next.next.next == null;

        // Test Case 2: Even number of nodes
        ListNode head2 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));

        ListNode result2 = oddEvenList(head2);

        assert result2.val == 1;
        assert result2.next.val == 3;
        assert result2.next.next.val == 2;
        assert result2.next.next.next.val == 4;
        assert result2.next.next.next.next == null;

        // Test Case 3: Two nodes
        ListNode head3 = new ListNode(1, new ListNode(2));

        ListNode result3 = oddEvenList(head3);

        assert result3.val == 1;
        assert result3.next.val == 2;
        assert result3.next.next == null;

        // Test Case 4: Single node
        ListNode head4 = new ListNode(1);

        assert oddEvenList(head4).val == 1;

        // Test Case 5: Empty list
        assert oddEvenList(null) == null;
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