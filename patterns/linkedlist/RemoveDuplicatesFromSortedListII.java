package patterns.linkedlist;

public class RemoveDuplicatesFromSortedListII {

    /*
     * Problem : Remove Duplicates from Sorted List II
     * LeetCode : #82
     * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
     * Pattern : Dummy Node / Two Pointers
     * Difficulty : Medium
     * Date Solved: 20-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - Create a dummy node before the head.
     * - Maintain prev as the last confirmed non-duplicate node.
     * - Use curr to traverse the linked list.
     * - If duplicates are found, skip all occurrences.
     * - Connect prev to the next distinct node.
     *
     * Optimal Approach:
     * - Single-pass traversal using a dummy node and two pointers.
     *
     * Pattern Insight:
     * - Dummy nodes simplify linked-list deletion, especially when
     * the head itself needs to be removed.
     * - Keep prev stationary while skipping duplicate nodes.
     *
     * Mistake I Made:
     * - Initially struggled with handling duplicates at the head.
     * - Pointer movement could skip nodes or lose track of the
     * previous non-duplicate node.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    /*
     * Problem Statement:
     * Given the head of a sorted linked list, delete all nodes
     * that have duplicate numbers, leaving only distinct numbers
     * from the original list.
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

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;

        ListNode prev = dummyNode;
        ListNode curr = head;

        while (curr != null) {
            if (curr.next != null && curr.val == curr.next.val) {
                int val = curr.val;

                while (curr != null && curr.val == val) {
                    curr = curr.next;
                }

                prev.next = curr;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }

        return dummyNode.next;
    }

    public static void main(String[] args) {

        // Test Case 1:
        // Input: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        // Output: 1 -> 2 -> 5

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = deleteDuplicates(n1);

        assert result.val == 1;
        assert result.next.val == 2;
        assert result.next.next.val == 5;
        assert result.next.next.next == null;

        // Test Case 2:
        // Input: 1 -> 1 -> 1 -> 2 -> 3
        // Output: 2 -> 3

        ListNode a = new ListNode(1);
        a.next = new ListNode(1);
        a.next.next = new ListNode(1);
        a.next.next.next = new ListNode(2);
        a.next.next.next.next = new ListNode(3);

        result = deleteDuplicates(a);

        assert result.val == 2;
        assert result.next.val == 3;
        assert result.next.next == null;

        // Test Case 3: All nodes are duplicates
        // Input: 1 -> 1
        // Output: null

        ListNode b = new ListNode(1);
        b.next = new ListNode(1);

        assert deleteDuplicates(b) == null;

        // Test Case 4: Empty list
        assert deleteDuplicates(null) == null;

        // Test Case 5: No duplicates
        // Input: 1 -> 2 -> 3
        // Output: 1 -> 2 -> 3

        ListNode c = new ListNode(1);
        c.next = new ListNode(2);
        c.next.next = new ListNode(3);

        result = deleteDuplicates(c);

        assert result.val == 1;
        assert result.next.val == 2;
        assert result.next.next.val == 3;
        assert result.next.next.next == null;

        System.out.println("All test cases passed!");
    }
}