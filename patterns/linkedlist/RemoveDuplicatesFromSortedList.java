package patterns.linkedlist;

public class RemoveDuplicatesFromSortedList {

    /*
     * Problem : Remove Duplicates from Sorted List
     * LeetCode : #83
     * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
     * Pattern : In-place Linked List Manipulation
     * Difficulty : Easy
     * Date Solved: 03-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Use a pointer to traverse the sorted linked list and compare each node
     * with its next node. If both values are equal, skip the next node.
     *
     * Optimal Approach:
     * Since the list is sorted, duplicate values are adjacent.
     * Maintain one pointer curr. If curr and curr.next have equal values,
     * update curr.next to curr.next.next. Otherwise, move curr forward.
     *
     * Pattern Insight:
     * In a sorted linked list, duplicates are consecutive.
     * We can remove duplicates by changing next pointers without using
     * extra space. Do not advance curr after removing a duplicate because
     * the next node may also be a duplicate.
     *
     * Mistake I Made:
     * Using two pointers and allowing the scanning pointer to become null
     * inside the inner loop. A single pointer is enough for this problem.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    /*
     * Problem Statement:
     * Given the head of a sorted linked list, delete all duplicates
     * so that each element appears only once. Return the linked list
     * sorted as well.
     */

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1,
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(3)))));

        ListNode result1 = deleteDuplicates(head1);

        assert result1.val == 1;
        assert result1.next.val == 2;
        assert result1.next.next.val == 3;
        assert result1.next.next.next == null;

        ListNode head2 = new ListNode(1,
                new ListNode(1,
                        new ListNode(1)));

        ListNode result2 = deleteDuplicates(head2);

        assert result2.val == 1;
        assert result2.next == null;

        ListNode head3 = new ListNode(1);
        ListNode result3 = deleteDuplicates(head3);

        assert result3.val == 1;
        assert result3.next == null;

        assert deleteDuplicates(null) == null;
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
