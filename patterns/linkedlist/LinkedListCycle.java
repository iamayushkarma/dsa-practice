package patterns.linkedlist;

public class LinkedListCycle {

    /*
     * Problem : Linked List Cycle
     * LeetCode : #141
     * Link: https://leetcode.com/problems/linked-list-cycle/
     * Pattern : Fast & Slow Pointers (Floyd's Cycle Detection)
     * Difficulty : Easy
     * Date Solved: 14-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Initialize two pointers, slow and fast, at the head.
     * Move slow one step and fast two steps in each iteration.
     * If both pointers meet, a cycle exists.
     * If fast reaches null or fast.next reaches null, no cycle exists.
     *
     * Optimal Approach:
     * Use Floyd's Cycle Detection Algorithm to detect a cycle
     * in a single traversal without using additional data structures.
     *
     * Pattern Insight:
     * When a cycle exists, the fast pointer moves twice as quickly
     * as the slow pointer.
     * Therefore, the fast pointer eventually catches the slow pointer
     * inside the cycle.
     *
     * If there is no cycle, the fast pointer eventually reaches null.
     *
     * Mistake I Made:
     * Initially used while(fast != slow) while both pointers started
     * at head. Since both pointers were initially equal, the loop
     * never executed.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    /*
     * Problem Statement:
     * Given the head of a linked list, determine whether the linked
     * list contains a cycle.
     *
     * Return true if a cycle exists, otherwise return false.
     */

    public static boolean hasCycle(ListNode head) {

        if (head == null || head.next == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow)
                return true;
        }

        return false;
    }

    // ListNode class for standalone execution.
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        // Test Case 1: Cycle exists.
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        assert hasCycle(head1);

        // Test Case 2: No cycle.
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);

        assert !hasCycle(head2);

        // Test Case 3: Single node without cycle.
        ListNode head3 = new ListNode(1);

        assert !hasCycle(head3);

        // Test Case 4: Single node with cycle.
        ListNode head4 = new ListNode(1);
        head4.next = head4;

        assert hasCycle(head4);

        // Test Case 5: Empty list.
        assert !hasCycle(null);

        System.out.println("All test cases passed!");
    }
}