package patterns.linkedlist;

public class MergeKSortedLists {

    /*
     * Problem : Merge k Sorted Lists
     * LeetCode : #23
     * Link: https://leetcode.com/problems/merge-k-sorted-lists/
     * Pattern : Linked List / Divide and Conquer (Pairwise Merging)
     * Difficulty : Hard
     * Date Solved: 21-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - Initialize head with the first linked list.
     * - Traverse the remaining lists using an enhanced for-loop.
     * - Merge the current result with each new list.
     * - Use a dummy node to build the merged sorted list.
     * - Reuse the existing nodes instead of creating new ones.
     *
     * Optimal Approach:
     * - Pairwise merging using divide and conquer can reduce
     * the time complexity compared with sequential merging.
     *
     * Pattern Insight:
     * - Merge two sorted linked lists by comparing their current nodes.
     * - Attach the smaller node to the result.
     * - When one list ends, attach the remaining nodes of the other list.
     *
     * Mistake I Made:
     * - Initially accessed node values without checking for null.
     * - Incorrectly advanced pointers after attaching nodes.
     * - Needed to attach the remaining part of the non-empty list.
     *
     * Time Complexity: O(kN), where k is the number of lists
     * and N is the total number of nodes.
     *
     * Space Complexity: O(1) auxiliary space for merging,
     * excluding the input linked lists.
     */

    /*
     * Problem Statement:
     * You are given an array of k linked lists, each sorted in
     * ascending order.
     *
     * Merge all the linked lists into one sorted linked list
     * and return its head.
     */

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

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;

        for (ListNode node : lists) {
            if (head == null) {
                head = node;
                continue;
            }

            head = mergeTwoLists(head, node);
        }

        return head;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newNode = new ListNode(0);
        ListNode newTemp = newNode;

        ListNode temp1 = list1;
        ListNode temp2 = list2;

        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                newTemp.next = temp1;
                newTemp = newTemp.next;
                temp1 = temp1.next;
            } else {
                newTemp.next = temp2;
                newTemp = newTemp.next;
                temp2 = temp2.next;
            }
        }

        if (temp1 == null) {
            newTemp.next = temp2;
        } else {
            newTemp.next = temp1;
        }

        return newNode.next;
    }

    public static void main(String[] args) {

        // Test Case 1:
        // Input:
        // lists = [[1,4,5], [1,3,4], [2,6]]
        //
        // Expected:
        // [1,1,2,3,4,4,5,6]

        ListNode a1 = new ListNode(1);
        a1.next = new ListNode(4);
        a1.next.next = new ListNode(5);

        ListNode b1 = new ListNode(1);
        b1.next = new ListNode(3);
        b1.next.next = new ListNode(4);

        ListNode c1 = new ListNode(2);
        c1.next = new ListNode(6);

        ListNode[] lists1 = { a1, b1, c1 };

        ListNode result = mergeKLists(lists1);

        int[] expected1 = { 1, 1, 2, 3, 4, 4, 5, 6 };

        for (int value : expected1) {
            assert result != null;
            assert result.val == value;
            result = result.next;
        }

        assert result == null;

        // Test Case 2: Empty array
        ListNode[] lists2 = {};
        assert mergeKLists(lists2) == null;

        // Test Case 3: Array containing empty lists
        ListNode[] lists3 = { null, null };
        assert mergeKLists(lists3) == null;

        // Test Case 4: Single linked list
        ListNode d1 = new ListNode(1);
        d1.next = new ListNode(2);
        d1.next.next = new ListNode(3);

        ListNode[] lists4 = { d1 };

        result = mergeKLists(lists4);

        assert result.val == 1;
        assert result.next.val == 2;
        assert result.next.next.val == 3;
        assert result.next.next.next == null;

        System.out.println("All test cases passed!");
    }
}