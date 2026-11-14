package patterns.linkedlist;

public class PalindromeLinkedList {

    /*
     * Problem : Palindrome Linked List
     * LeetCode : #234
     * Link: https://leetcode.com/problems/palindrome-linked-list/
     * Pattern : Fast & Slow Pointers + Linked List Reversal
     * Difficulty : Easy
     * Date Solved: 14-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Find the middle of the linked list using slow and fast pointers.
     * For odd-length lists, skip the middle node.
     * Reverse the second half of the linked list.
     * Compare the reversed second half with the first half.
     *
     * Optimal Approach:
     * The same approach achieves O(n) time and O(1) auxiliary space.
     * It reverses the second half in-place without using an extra
     * array or stack.
     *
     * Pattern Insight:
     * Fast and slow pointers help locate the middle of a linked list.
     * Reversing the second half allows comparison of both halves
     * using constant auxiliary space.
     *
     * Mistake I Made:
     * Used an incorrect base condition:
     * head != null || head.next != null
     * It should be:
     * head == null || head.next == null
     *
     * Also, the second half must be reversed separately, and
     * comparison should use head and the reversed half's head.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */

    /*
     * Problem Statement:
     * Given the head of a singly linked list, return true if it is
     * a palindrome or false otherwise.
     */

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        fast = head;

        ListNode prev = null;

        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        while (prev != null) {
            if (head.val != prev.val)
                return false;
            head = head.next;
            prev = prev.next;
        }

        return true;
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

    public static void main(String[] args) {

        // Test Case 1: Even-length palindrome
        ListNode list1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(2,
                                new ListNode(1))));

        assert isPalindrome(list1);

        // Test Case 2: Not a palindrome
        ListNode list2 = new ListNode(1,
                new ListNode(2));

        assert !isPalindrome(list2);

        // Test Case 3: Odd-length palindrome
        ListNode list3 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(2,
                                        new ListNode(1)))));

        assert isPalindrome(list3);

        // Test Case 4: Single node
        ListNode list4 = new ListNode(1);

        assert isPalindrome(list4);

        // Test Case 5: Empty list
        assert isPalindrome(null);

        System.out.println("All test cases passed!");
    }
}