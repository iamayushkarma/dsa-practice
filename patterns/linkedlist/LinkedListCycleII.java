package patterns.linkedlist;

public class LinkedListCycleII {

    /*
     * Problem : Linked List Cycle II
     * LeetCode : #142
     * Link: https://leetcode.com/problems/linked-list-cycle-ii/
     * Pattern : Fast & Slow Pointers (Floyd's Cycle Detection)
     * Difficulty : Medium
     * Date Solved: 14-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Initialize slow and fast pointers at the head.
     * Move slow one step and fast two steps until they meet.
     * If fast reaches null or fast.next reaches null, no cycle exists.
     * After detecting a cycle, reset slow to head.
     * Move both pointers one step at a time.
     * Their next meeting point is the cycle's starting node.
     *
     * Optimal Approach:
     * Use Floyd's Cycle Detection Algorithm in two phases.
     * Phase 1: Detect whether a cycle exists.
     * Phase 2: Find the cycle entry by resetting one pointer
     * to the head and moving both pointers at the same speed.
     *
     * Pattern Insight:
     * Let:
     * L = Distance from head to cycle starting point.
     * C = Length of the cycle.
     * X = Distance from cycle starting point to meeting point.
     *
     * When slow and fast meet, the fast pointer has travelled
     * twice the distance of the slow pointer.
     *
     * This mathematical relationship ensures that resetting
     * one pointer to head and moving both one step at a time
     * makes them meet at the cycle entry.
     *
     * Mistake I Made:
     * Initially used while(fast != slow) while both pointers
     * started at head. Since they were initially equal,
     * the loop never executed.
     * Fixed this using while(true), checking for null before
     * moving pointers and breaking when they meet.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    /*
     * Problem Statement:
     * Given the head of a linked list, return the node where
     * the cycle begins.
     *
     * If there is no cycle, return null.
     */

    public static ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Detect the cycle.
        while (true) {

            if (fast == null || fast.next == null)
                return null;

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }

        // Phase 2: Find the cycle starting node.
        slow = head;

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
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

        // Test Case 1: Cycle starts at position 1.
        ListNode head1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        assert detectCycle(head1) == node2;

        // Test Case 2: Cycle starts at head.
        ListNode head2 = new ListNode(1);
        ListNode node22 = new ListNode(2);

        head2.next = node22;
        node22.next = head2;

        assert detectCycle(head2) == head2;

        // Test Case 3: No cycle.
        ListNode head3 = new ListNode(1);
        head3.next = new ListNode(2);

        assert detectCycle(head3) == null;

        // Test Case 4: Single node with cycle.
        ListNode head4 = new ListNode(1);
        head4.next = head4;

        assert detectCycle(head4) == head4;

        // Test Case 5: Empty list.
        assert detectCycle(null) == null;

        System.out.println("All test cases passed!");
    }
}