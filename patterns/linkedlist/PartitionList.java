package patterns.linkedlist;

public class PartitionList {

    /*
     * Problem : Partition List
     * LeetCode : #86
     * Link: https://leetcode.com/problems/partition-list/
     * Pattern : Linked List Manipulation | Two Dummy Lists
     * Difficulty : Medium
     * Date Solved: 09-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Create two separate linked lists using dummy nodes.
     * Traverse the original list and create new nodes.
     * Place nodes with values smaller than x in the left list
     * and nodes greater than or equal to x in the right list.
     * Finally, connect both lists.
     *
     * Optimal Approach:
     * Reuse the original nodes instead of creating new ones.
     * Maintain two dummy lists with tail pointers.
     * Append each existing node to the appropriate list.
     * Terminate the right list and connect the left list to it.
     *
     * Pattern Insight:
     * Dummy nodes simplify building multiple linked lists.
     * Tail pointers help append nodes efficiently.
     * Preserve the relative order of nodes in both lists.
     *
     * Mistake I Made:
     * Initially connected the left list to the right dummy node
     * instead of the first actual node using right.next.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) for my approach
     */

    /*
     * Problem Statement:
     * Given the head of a linked list and a value x, partition it
     * so that all nodes with values less than x come before nodes
     * with values greater than or equal to x.
     *
     * Preserve the original relative order of nodes in both groups.
     */

    public static ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode(0);
        ListNode leftHead = left;

        ListNode right = new ListNode(0);
        ListNode rightHead = right;

        ListNode tempHead = head;

        while (tempHead != null) {
            if (tempHead.val < x) {
                ListNode tempLeft = new ListNode(tempHead.val);
                leftHead.next = tempLeft;
                leftHead = leftHead.next;
            } else {
                ListNode tempRigth = new ListNode(tempHead.val);
                rightHead.next = tempRigth;
                rightHead = rightHead.next;
            }

            tempHead = tempHead.next;
        }

        leftHead.next = right.next;

        return left.next;
    }

    public static void main(String[] args) {

        // Test Case 1
        // Input: [1, 4, 3, 2, 5, 2], x = 3
        // Expected: [1, 2, 2, 4, 3, 5]

        ListNode head1 = new ListNode(1,
                new ListNode(4,
                        new ListNode(3,
                                new ListNode(2,
                                        new ListNode(5,
                                                new ListNode(2))))));

        ListNode result1 = partition(head1, 3);

        assert result1.val == 1;
        assert result1.next.val == 2;
        assert result1.next.next.val == 2;
        assert result1.next.next.next.val == 4;
        assert result1.next.next.next.next.val == 3;
        assert result1.next.next.next.next.next.val == 5;
        assert result1.next.next.next.next.next.next == null;

        // Test Case 2
        // Input: [2, 1], x = 2
        // Expected: [1, 2]

        ListNode head2 = new ListNode(2, new ListNode(1));

        ListNode result2 = partition(head2, 2);

        assert result2.val == 1;
        assert result2.next.val == 2;
        assert result2.next.next == null;

        // Test Case 3
        // All nodes smaller than x

        ListNode head3 = new ListNode(1, new ListNode(2));

        ListNode result3 = partition(head3, 3);

        assert result3.val == 1;
        assert result3.next.val == 2;
        assert result3.next.next == null;

        // Test Case 4
        // All nodes greater than or equal to x

        ListNode head4 = new ListNode(4, new ListNode(5));

        ListNode result4 = partition(head4, 3);

        assert result4.val == 4;
        assert result4.next.val == 5;
        assert result4.next.next == null;

        // Test Case 5: Empty list
        assert partition(null, 3) == null;
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