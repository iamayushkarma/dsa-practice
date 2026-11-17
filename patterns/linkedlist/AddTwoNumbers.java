package patterns.linkedlist;

public class AddTwoNumbers {

    /*
     * Problem : Add Two Numbers
     * LeetCode : #2
     * Link: https://leetcode.com/problems/add-two-numbers/
     * Pattern : Linked List + Dummy Node + Carry
     * Difficulty : Medium
     * Date Solved: 17-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Traverse both linked lists simultaneously.
     * Add corresponding digits along with the carry.
     * Create a new node for each resulting digit.
     * Continue until both lists are completely traversed.
     *
     * Optimal Approach:
     * Use a dummy node to build the result linked list.
     * Calculate sum = num1 + num2 + carry.
     * Store sum % 10 as the current digit.
     * Update carry using sum / 10.
     * Append any remaining carry after traversal.
     *
     * Pattern Insight:
     * When adding numbers represented by linked lists in reverse order,
     * process one digit at a time while maintaining a carry.
     * Use a dummy node to simplify result-list construction.
     *
     * Mistake I Made:
     * Initially used incorrect loop conditions and carry calculations.
     * Also handled unequal list lengths separately instead of
     * using null checks inside a single loop.
     *
     * Time Complexity: O(max(m, n))
     * Space Complexity: O(max(m, n)) for the result linked list.
     */

    /*
     * Problem Statement:
     * Given two non-empty linked lists representing non-negative
     * integers in reverse order, add the numbers and return the
     * resulting sum as a linked list.
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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode resTemp = res;
        int carry = 0;

        ListNode ltemp1 = l1;
        ListNode ltemp2 = l2;

        while (ltemp1 != null || ltemp2 != null) {
            int num1 = (ltemp1 != null) ? ltemp1.val : 0;
            int num2 = (ltemp2 != null) ? ltemp2.val : 0;

            int sum = num1 + num2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            ListNode newNode = new ListNode(sum);
            resTemp.next = newNode;
            resTemp = resTemp.next;

            if (ltemp1 != null) {
                ltemp1 = ltemp1.next;
            }

            if (ltemp2 != null) {
                ltemp2 = ltemp2.next;
            }
        }

        if (carry > 0) {
            resTemp.next = new ListNode(carry);
        }

        return res.next;
    }

    // Helper method to create a linked list.
    public static ListNode createList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        for (int value : values) {
            temp.next = new ListNode(value);
            temp = temp.next;
        }

        return dummy.next;
    }

    // Helper method to compare linked lists.
    public static boolean isEqual(ListNode l1, ListNode l2) {
        while (l1 != null && l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        return l1 == null && l2 == null;
    }

    public static void main(String[] args) {

        // Example 1: 342 + 465 = 807
        ListNode l1 = createList(new int[] { 2, 4, 3 });
        ListNode l2 = createList(new int[] { 5, 6, 4 });

        ListNode expected1 = createList(new int[] { 7, 0, 8 });

        assert isEqual(addTwoNumbers(l1, l2), expected1);

        // Example 2: 0 + 0 = 0
        ListNode l3 = createList(new int[] { 0 });
        ListNode l4 = createList(new int[] { 0 });

        ListNode expected2 = createList(new int[] { 0 });

        assert isEqual(addTwoNumbers(l3, l4), expected2);

        // Example 3: Different list lengths with final carry
        ListNode l5 = createList(new int[] { 9, 9, 9, 9, 9, 9, 9 });
        ListNode l6 = createList(new int[] { 9, 9, 9, 9 });

        ListNode expected3 = createList(new int[] { 8, 9, 9, 9, 0, 0, 0, 1 });

        assert isEqual(addTwoNumbers(l5, l6), expected3);

        System.out.println("All test cases passed!");
    }
}