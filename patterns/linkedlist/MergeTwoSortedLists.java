package patterns.linkedlist;

public class MergeTwoSortedLists {

    /*
     * Problem : Merge Two Sorted Lists
     * LeetCode : #21
     * Link: https://leetcode.com/problems/merge-two-sorted-lists/
     * Pattern : Linked List / Two Pointers
     * Difficulty : Easy
     * Date Solved: 02-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Use a dummy node to build the merged list.
     * Compare the current nodes of both lists and attach the smaller node.
     * Move the pointer of the selected list forward.
     * Attach the remaining nodes after one list becomes empty.
     *
     * Optimal Approach:
     * Reuse the existing nodes instead of creating new nodes.
     * The dummy node simplifies handling the head of the merged list.
     *
     * Pattern Insight:
     * Two Pointers on Sorted Linked Lists.
     * Compare current values and always attach the smaller node.
     *
     * Mistake I Made:
     * No specific mistake reported.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     */

    // Given the heads of two sorted linked lists, merge them into
    // one sorted linked list and return its head.

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode merge = new ListNode(0);
        ListNode mergeHead = merge;

        ListNode list1Head = list1;
        ListNode list2Head = list2;

        while (list1Head != null && list2Head != null) {
            int val1 = list1Head.val;
            int val2 = list2Head.val;

            if (val1 <= val2) {
                mergeHead.next = list1Head;
                list1Head = list1Head.next;
            } else {
                mergeHead.next = list2Head;
                list2Head = list2Head.next;
            }

            mergeHead = mergeHead.next;
        }

        mergeHead.next = (list1Head != null) ? list1Head : list2Head;

        return merge.next;
    }

    public static void main(String[] args) {

        // Test case 1:
        // list1 = 1 -> 2 -> 4
        // list2 = 1 -> 3 -> 4
        // Expected: 1 -> 1 -> 2 -> 3 -> 4 -> 4

        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode result1 = mergeTwoLists(list1, list2);

        assert result1.val == 1;
        assert result1.next.val == 1;
        assert result1.next.next.val == 2;
        assert result1.next.next.next.val == 3;
        assert result1.next.next.next.next.val == 4;
        assert result1.next.next.next.next.next.val == 4;
        assert result1.next.next.next.next.next.next == null;

        // Test case 2:
        // list1 = null
        // list2 = 0
        // Expected: 0

        ListNode list3 = null;
        ListNode list4 = new ListNode(0);

        ListNode result2 = mergeTwoLists(list3, list4);

        assert result2.val == 0;
        assert result2.next == null;

        // Test case 3:
        // Both lists are empty
        // Expected: null

        ListNode result3 = mergeTwoLists(null, null);

        assert result3 == null;
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