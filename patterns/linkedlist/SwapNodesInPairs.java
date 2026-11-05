package patterns.linkedlist;

public class SwapNodesInPairs {
    /*
     * Problem : Swap Nodes in Pairs
     * LeetCode : #24
     * Link: https://leetcode.com/problems/swap-nodes-in-pairs/
     * Pattern : Linked List Pointer Manipulation
     * Difficulty : Medium
     * Date Solved: 03-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Use a dummy node before the head and maintain prev and curr pointers.
     * For each pair, save the second node, detach the first node from it,
     * reverse their connection, and connect the previous node to the pair.
     *
     * Optimal Approach:
     * Use a dummy node and swap adjacent nodes by changing their next pointers.
     * Move prev to the first node of the swapped pair and continue.
     *
     * Pattern Insight:
     * A dummy node simplifies swapping the first pair because prev always
     * points to the node before the pair. Rewire the links in a safe order
     * so no nodes are lost.
     *
     * Mistake I Made:
     * Connected the second node to prev instead of curr, and returned head
     * instead of dummy.next after swapping the first pair.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    /*
     * Problem Statement:
     * Given the head of a linked list, swap every two adjacent nodes
     * and return its head. You must solve the problem by changing
     * the nodes' links, not their values.
     */

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            ListNode nextNode = curr.next;

            curr.next = curr.next.next;
            nextNode.next = curr;
            prev.next = nextNode;

            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode pairFirst = new ListNode(1);
        ListNode pairSecond = new ListNode(2);
        pairFirst.next = pairSecond;
        ListNode pairResult = swapPairs(pairFirst);
        assert pairResult.val == 2;
        assert pairResult == pairSecond;
        assert pairResult.next.val == 1;
        assert pairResult.next == pairFirst;
        assert pairResult.next.next == null;

        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        first.next = second;
        second.next = third;
        third.next = fourth;

        ListNode result1 = swapPairs(first);

        assert result1.val == 2;
        assert result1 == second;
        assert result1.next.val == 1;
        assert result1.next == first;
        assert result1.next.next.val == 4;
        assert result1.next.next == fourth;
        assert result1.next.next.next.val == 3;
        assert result1.next.next.next == third;
        assert result1.next.next.next.next == null;

        ListNode oddFirst = new ListNode(1);
        ListNode oddSecond = new ListNode(2);
        ListNode oddThird = new ListNode(3);
        oddFirst.next = oddSecond;
        oddSecond.next = oddThird;

        ListNode result2 = swapPairs(oddFirst);

        assert result2.val == 2;
        assert result2 == oddSecond;
        assert result2.next.val == 1;
        assert result2.next == oddFirst;
        assert result2.next.next.val == 3;
        assert result2.next.next == oddThird;
        assert result2.next.next.next == null;

        ListNode head3 = new ListNode(1);
        assert swapPairs(head3) == head3;
        assert swapPairs(null) == null;
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
