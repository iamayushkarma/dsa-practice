package patterns.linkedlist;

public class MiddleOfTheLinkedList {

    /*
     * Problem : Middle of the Linked List
     * LeetCode : #876
     * Link: https://leetcode.com/problems/middle-of-the-linked-list/
     * Pattern : Fast & Slow Pointers (Tortoise and Hare)
     * Difficulty : Easy
     * Date Solved: 14-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Initialize two pointers, slow and fast, at the head.
     * Move slow one step and fast two steps in every iteration.
     * When fast reaches the end, slow points to the middle node.
     *
     * Optimal Approach:
     * Use the Fast & Slow Pointer technique to find the middle
     * in a single traversal without calculating the list length.
     *
     * Pattern Insight:
     * The fast pointer moves twice as quickly as the slow pointer.
     * Therefore, when fast reaches the end, slow has travelled
     * approximately half the linked-list length.
     *
     * For an even-length list, this approach returns the second
     * middle node.
     *
     * Mistake I Made:
     * No significant implementation mistake.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    /*
     * Problem Statement:
     * Given the head of a singly linked list, return the middle node.
     * If there are two middle nodes, return the second middle node.
     */

    public static ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // ListNode class for standalone execution.
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

        // Test Case 1: Odd-length list.
        ListNode head1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        ListNode result1 = middleNode(head1);
        assertValues(result1, 3, 4, 5);

        // Test Case 2: Even-length list.
        ListNode head2 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6))))));

        ListNode result2 = middleNode(head2);
        assertValues(result2, 4, 5, 6);

        // Test Case 3: Single-node list.
        ListNode head3 = new ListNode(1);

        ListNode result3 = middleNode(head3);
        assertValues(result3, 1);

        // Test Case 4: Two-node list.
        ListNode head4 = new ListNode(1,
                new ListNode(2));

        ListNode result4 = middleNode(head4);
        assertValues(result4, 2);

        System.out.println("All test cases passed!");
    }
}