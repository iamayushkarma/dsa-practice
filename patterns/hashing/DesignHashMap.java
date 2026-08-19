package patterns.hashing;

import java.util.HashMap;
import java.util.Map;

public class DesignHashMap {
    /*
     * Problem : Design HashMap
     * LeetCode : #706
     * Link: https://leetcode.com/problems/design-hashmap/
     * Pattern : Hashing
     * Difficulty : Easy
     * Date Solved: 19-08-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * I used a HashMap to store key-value pairs.
     *
     * The key is used to identify the value stored in the map.
     *
     * Operations:
     * - put(key, value):
     * Add the key-value pair. If the key already exists, update its value.
     *
     * - get(key):
     * Return the value associated with the key.
     * If the key does not exist, return -1.
     *
     * - remove(key):
     * Remove the key-value pair if the key exists.
     *
     * Important:
     * A key can have only one value.
     * Therefore, calling put() again with the same key should replace
     * the previous value.
     *
     * Optimal Approach:
     * HashMap is designed exactly for key-value storage.
     * It provides O(1) average time for put, get, and remove operations.
     *
     * Pattern Insight:
     * This is a Hashing problem because:
     * - We need fast lookup using a key.
     * - We need to store and update key-value pairs.
     * - HashMap provides O(1) average lookup, insertion, and deletion.
     *
     * Trigger:
     * "Design a data structure that supports put, get, and remove"
     * → Think: HashMap / key-value mapping
     *
     * Mistake I Made:
     * - The important part is handling an existing key correctly.
     * - put() must update the value instead of creating another entry.
     * - get() must return -1 when the key does not exist.
     *
     * Time Complexity:
     * put(): O(1) average
     * get(): O(1) average
     * remove(): O(1) average
     *
     * Space Complexity: O(n)
     */

    private Map<Integer, Integer> map;

    public DesignHashMap() {
        map = new HashMap<>();
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public int get(int key) {
        return map.getOrDefault(key, -1);
    }

    public void remove(int key) {
        map.remove(key);
    }

    public static void main(String[] args) {
        DesignHashMap obj = new DesignHashMap();

        obj.put(1, 10);
        obj.put(2, 20);

        System.out.println("Get key 1: " + obj.get(1));

        obj.put(1, 15);
        System.out.println("Updated key 1: " + obj.get(1));

        obj.remove(1);
        System.out.println("After removing key 1: " + obj.get(1));
    }
}