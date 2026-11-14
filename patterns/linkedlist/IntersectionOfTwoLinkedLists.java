package patterns.linkedlist;

public class IntersectionOfTwoLinkedLists {

    /*
     * Problem : Intersection of Two Linked Lists
     * LeetCode : #160
     * Link: https://leetcode.com/problems/intersection-of-two-linked-lists/
     * Pattern : Two Pointers + Length Difference
     * Difficulty : Easy
     * Date Solved: 14-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Calculate the lengths of both linked lists.
     * Find the difference between their lengths.
     * Move the pointer of the longer list forward by that difference.
     * Traverse both lists simultaneously until they point to the
     * same node or both reach null.
     *
     * Optimal Approach:
     * Use two pointers and switch their starting lists when they
     * reach the end.
     * Both pointers traverse the same total distance and eventually
     * meet at the intersection node or at null.
     *
     * Pattern Insight:
     * When two lists intersect, they share the same physical nodes
     * from the intersection onward.
     *
     * Length alignment ensures both pointers have an equal number
     * of nodes remaining before reaching the intersection.
     *
     * Mistake I Made:
     * 1. Initialized lengths with 1 instead of 0.
     * 2. Moved both pointers before comparing them, skipping the
     * initially aligned nodes.
     * 3. Used an unnecessary null check inside the traversal loop.
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(1)
     */

    /*
     * Problem Statement:
     * Given the heads of two singly linked lists, return the node
     * at which the two lists intersect.
     *
     * If the two linked lists do not intersect, return null.
     *
     * Intersection is determined by node reference, not node value.
     */

    public static ListNode getIntersectionNode(
            ListNode headA, ListNode headB) {

        if (headA == null || headB == null)
            return null;

        int len1 = 0;
        int len2 = 0;

        ListNode temp = headA;

        // Calculate length of first linked list
        while (temp != null) {
            len1++;
            temp = temp.next;
        }

        temp = headB;

        // Calculate length of second linked list
        while (temp != null) {
            len2++;
            temp = temp.next;
        }

        // Calculate length difference
        int diff = Math.abs(len2 - len1);

        ListNode temp1 = headA;
        ListNode temp2 = headB;

        // Align both pointers
        if (len2 > len1) {
            for (int i = 0; i < diff; i++)
                temp2 = temp2.next;
        } else {
            for (int i = 0; i < diff; i++)
                temp1 = temp1.next;
        }

        // Find intersection
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return temp1;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        // Test Case 1: Intersection exists
        ListNode intersection = new ListNode(8);
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);

        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersection;

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersection;

        assert getIntersectionNode(headA, headB) == intersection;

        // Test Case 2: No intersection
        ListNode listA = new ListNode(1);
        listA.next = new ListNode(2);

        ListNode listB = new ListNode(3);
        listB.next = new ListNode(4);

        assert getIntersectionNode(listA, listB) == null;

        // Test Case 3: Intersection at head
        ListNode shared = new ListNode(7);
        shared.next = new ListNode(9);

        assert getIntersectionNode(shared, shared) == shared;

        // Test Case 4: One empty list
        assert getIntersectionNode(null, listA) == null;

        // Test Case 5: Both lists empty
        assert getIntersectionNode(null, null) == null;

        // Test Case 6: Different values but same reference
        ListNode common = new ListNode(10);

        ListNode first = new ListNode(1);
        first.next = common;

        ListNode second = new ListNode(2);
        second.next = common;

        assert getIntersectionNode(first, second) == common;

        System.out.println("All test cases passed!");
    }
}