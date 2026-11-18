package patterns.linkedlist;

public class FlattenAMultilevelDoublyLinkedList {

    /*
     * Problem : Flatten a Multilevel Doubly Linked List
     * LeetCode : #430
     * Link: https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
     * Pattern : Recursion / Doubly Linked List
     * Difficulty : Medium
     * Date Solved: 18-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - Traverse the doubly linked list.
     * - If a node has a child, recursively flatten the child list.
     * - Insert the flattened child list between the current node and its next node.
     * - Reconnect prev and next pointers.
     * - Set the child pointer to null.
     *
     * Optimal Approach:
     * - Recursive in-place flattening.
     *
     * Pattern Insight:
     * - Recursively process child lists and insert them into the main list.
     * - Maintain correct prev and next connections while rearranging nodes.
     *
     * Mistake I Made:
     * - Forgot to clear the child pointer.
     * - Accessed next.prev without checking whether next was null.
     * - Needed to reconnect the original next node after flattening the child list.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(d), where d is the maximum nesting depth.
     */

    /*
     * Problem Statement:
     * Given a multilevel doubly linked list, flatten it into a
     * single-level doubly linked list.
     *
     * Child lists must be inserted immediately after their parent node.
     * The order must follow depth-first traversal.
     * All child pointers must be set to null.
     */

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        Node(int val) {
            this.val = val;
        }
    }

    public static Node flatten(Node head) {
        if (head == null)
            return null;

        Node temp = head;

        while (temp != null) {
            if (temp.child != null) {
                Node nextNode = temp.next;
                Node faltenNode = flatten(temp.child);

                temp.next = faltenNode;
                temp.next.prev = temp;
                temp.child = null;

                while (temp.next != null)
                    temp = temp.next;

                temp.next = nextNode;
                if (nextNode != null) {
                    nextNode.prev = temp;
                }
            }

            temp = temp.next;
        }

        return head;
    }

    public static void main(String[] args) {

        // Test Case 1
        // 1 <-> 2 <-> 3 <-> 4
        // |
        // 7 <-> 8
        //
        // Expected:
        // 1 <-> 2 <-> 3 <-> 7 <-> 8 <-> 4

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n7 = new Node(7);
        Node n8 = new Node(8);

        n1.next = n2;
        n2.prev = n1;

        n2.next = n3;
        n3.prev = n2;

        n3.next = n4;
        n4.prev = n3;

        n3.child = n7;

        n7.next = n8;
        n8.prev = n7;

        Node result = flatten(n1);

        assert result == n1;
        assert n1.next == n2;
        assert n2.next == n3;
        assert n3.next == n7;
        assert n7.prev == n3;
        assert n7.next == n8;
        assert n8.next == n4;
        assert n4.prev == n8;
        assert n3.child == null;

        // Test Case 2: Null list
        assert flatten(null) == null;

        // Test Case 3: Single node
        Node single = new Node(10);

        assert flatten(single) == single;
        assert single.next == null;
        assert single.child == null;

        System.out.println("All test cases passed!");
    }
}