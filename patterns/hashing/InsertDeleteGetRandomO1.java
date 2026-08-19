package patterns.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGetRandomO1 {
    /*
     * Problem : Insert Delete GetRandom O(1)
     * LeetCode : #380
     * Link: https://leetcode.com/problems/insert-delete-getrandom-o1/
     * Pattern : Hashing
     * Difficulty : Medium
     * Date Solved: 19-08-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * I used a HashMap and an ArrayList together.
     *
     * The HashMap stores:
     * - Key -> value
     * - Value -> index of that value in the ArrayList
     *
     * The ArrayList stores all values so that we can get a random
     * element using a random index in O(1).
     *
     * While inserting:
     * - If the value already exists, return false.
     * - Otherwise, store its index in the HashMap and add it to the ArrayList.
     *
     * While removing:
     * - Find the index of the value using the HashMap.
     * - Take the last element from the ArrayList.
     * - Move the last element to the position of the element being removed.
     * - Update the last element's index in the HashMap.
     * - Remove the last element from the ArrayList.
     * - Remove the value from the HashMap.
     *
     * Important:
     * We cannot directly remove an element from the middle of an ArrayList
     * because that would shift the remaining elements and take O(n).
     *
     * Instead, we replace the element with the last element and then remove
     * the last element. Removing the last element is O(1).
     *
     * For example:
     *
     * [10, 20, 30, 40]
     *
     * Remove 20:
     *
     * Move 40 to index 1:
     * [10, 40, 30, 40]
     *
     * Remove the last element:
     * [10, 40, 30]
     *
     * Optimal Approach:
     * HashMap gives O(1) average lookup for checking whether a value exists
     * and finding its index.
     *
     * ArrayList gives O(1) access by index and allows us to generate a
     * random element efficiently.
     *
     * Pattern Insight:
     * This is a Hashing + ArrayList problem because:
     * - HashMap gives fast value-to-index lookup.
     * - ArrayList gives O(1) random access.
     * - Combining both allows insert, delete, and random access in O(1).
     *
     * Trigger:
     * "Insert, delete, and get random element in O(1)"
     * → Think: HashMap + ArrayList
     *
     * Mistake I Made:
     * - Directly removing an element from the middle of an ArrayList
     * would take O(n) because elements need to be shifted.
     * - The correct trick is to replace the removed element with the
     * last element and then remove the last element.
     * - The HashMap index must also be updated after the swap.
     *
     * Time Complexity:
     * insert(): O(1) average
     * remove(): O(1) average
     * getRandom(): O(1)
     *
     * Space Complexity: O(n)
     */

    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random random;

    public InsertDeleteGetRandomO1() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int lastValue = list.get(list.size() - 1);

        // Move the last element to the removed element's position
        list.set(index, lastValue);

        // Update the last element's index
        map.put(lastValue, index);

        // Remove the last element
        list.remove(list.size() - 1);

        // Remove the value from the HashMap
        map.remove(val);

        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }

    public static void main(String[] args) {
        InsertDeleteGetRandomO1 obj = new InsertDeleteGetRandomO1();

        System.out.println("Insert 10: " + obj.insert(10));
        System.out.println("Insert 20: " + obj.insert(20));
        System.out.println("Insert 10 again: " + obj.insert(10));

        System.out.println("Remove 10: " + obj.remove(10));
        System.out.println("Remove 10 again: " + obj.remove(10));

        System.out.println("Random value: " + obj.getRandom());
    }
}