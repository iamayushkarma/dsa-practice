package patterns.linkedlist;

import java.util.HashMap;

public class CopyListWithRandomPointer {

    /*
     * Problem : Copy List with Random Pointer
     * LeetCode : #138
     * Link: https://leetcode.com/problems/copy-list-with-random-pointer/
     * Pattern : Linked List + HashMap
     * Difficulty : Medium
     * Date Solved: 17-Nov-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Use a HashMap to maintain the mapping between original nodes
     * and their corresponding deep-copied nodes.
     *
     * First traversal:
     * Create copies of all nodes and store their mappings.
     *
     * Second traversal:
     * Assign random pointers using the HashMap.
     *
     * Optimal Approach:
     * The interweaving approach creates copied nodes between original
     * nodes and establishes random pointers without a HashMap.
     * This achieves O(1) auxiliary space.
     *
     * Pattern Insight:
     * When a linked list contains pointers to arbitrary nodes,
     * use a HashMap to maintain the relationship between original
     * nodes and their copies.
     *
     * Mistake I Made:
     * Initially mapped original nodes to incorrect copied nodes.
     * Also used random node values as indices instead of using
     * actual node references.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n) for the HashMap and copied list.
     */

    /*
     * Problem Statement:
     * Given a linked list where each node contains a value,
     * a next pointer, and a random pointer, create a deep copy
     * of the entire linked list.
     *
     * The random pointer can point to any node in the list
     * or null.
     */

    static class Node {
        int val;
        Node next;
        Node random;

        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {

        if (head == null)
            return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node deepCopy = new Node(head.val);
        Node deepCopyTemp = deepCopy;
        Node temp = head.next;

        map.put(head, deepCopy);

        // First traversal: Create copied nodes.
        while (temp != null) {

            Node newNode = new Node(temp.val);

            map.put(temp, newNode);

            deepCopyTemp.next = newNode;
            deepCopyTemp = deepCopyTemp.next;
            temp = temp.next;
        }

        deepCopyTemp.next = null;

        // Second traversal: Assign random pointers.
        deepCopyTemp = deepCopy;
        temp = head;

        while (deepCopyTemp != null) {
            deepCopyTemp.random = map.get(temp.random);

            temp = temp.next;
            deepCopyTemp = deepCopyTemp.next;
        }

        return deepCopy;
    }

    // Helper method to verify deep copy.
    public static boolean isDeepCopy(Node original, Node copied) {

        HashMap<Node, Node> map = new HashMap<>();

        Node temp1 = original;
        Node temp2 = copied;

        while (temp1 != null && temp2 != null) {

            if (temp1 == temp2 || temp1.val != temp2.val) {
                return false;
            }

            map.put(temp1, temp2);

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        if (temp1 != null || temp2 != null) {
            return false;
        }

        temp1 = original;
        temp2 = copied;

        while (temp1 != null) {

            if (temp2.random != map.get(temp1.random)) {
                return false;
            }

            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return true;
    }

    public static void main(String[] args) {

        // Test Case 1
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        Node copied = copyRandomList(n1);

        assert isDeepCopy(n1, copied);

        // Test Case 2: Empty list
        assert copyRandomList(null) == null;

        // Test Case 3: Single node with null random
        Node single = new Node(1);

        Node singleCopy = copyRandomList(single);

        assert singleCopy != single;
        assert singleCopy.val == 1;
        assert singleCopy.next == null;
        assert singleCopy.random == null;

        // Test Case 4: Single node pointing to itself
        Node self = new Node(5);
        self.random = self;

        Node selfCopy = copyRandomList(self);

        assert selfCopy != self;
        assert selfCopy.random == selfCopy;

        System.out.println("All test cases passed!");
    }
}