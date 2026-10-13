package patterns.binary_search;

import java.util.*;

public class TimeBasedKeyValueStore {

    /*
     * Problem : Time Based Key-Value Store
     * LeetCode : #981
     * Link: https://leetcode.com/problems/time-based-key-value-store/
     * Pattern : Hashing + Binary Search
     * Difficulty : Medium
     * Date Solved: 13-Oct-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     *
     * - Used a HashMap to store each key and its history.
     * - Each key maps to an ArrayList of TimeValue objects.
     * - Each TimeValue object stores a timestamp and its value.
     * - The set() method adds new timestamp-value pairs to the
     * list associated with the given key.
     * - The get() method uses binary search to find the value
     * associated with the largest timestamp <= the requested
     * timestamp.
     *
     * Why It Works:
     *
     * - A HashMap provides efficient access to a key's history.
     * - Timestamps for a given key are strictly increasing,
     * so its list remains sorted by timestamp.
     * - Binary search efficiently locates the required entry.
     * - If an exact timestamp is found, return its value.
     * - Otherwise, high points to the last timestamp smaller
     * than the requested timestamp when the search ends.
     * - If high < 0, no valid timestamp exists, so return "".
     *
     * Pattern Insight:
     *
     * - Use hashing when data must be retrieved by a key.
     * - Use binary search when searching sorted data.
     * - The key observation is that get() does not require
     * an exact timestamp match.
     * - We need the floor timestamp: the largest timestamp
     * that does not exceed the requested timestamp.
     *
     * Mistake I Made:
     *
     * - Returned the only stored value without checking
     * whether its timestamp was <= the requested timestamp.
     * - This failed when the requested timestamp was earlier
     * than the only stored timestamp.
     * - Initially used an incorrect return type and accessed
     * the timestamp and value fields incorrectly.
     * - Used an undefined variable in the binary search.
     * - Placed the high < 0 check inside the search loop,
     * instead of after the loop.
     *
     * Time Complexity:
     *
     * - set(): O(1) amortized
     * - get(): O(log n), where n is the number of entries
     * associated with the requested key.
     *
     * Space Complexity: O(N)
     *
     * - N is the total number of timestamp-value pairs stored.
     *
     */

    static class TimeValue {
        int timestamp;
        String value;

        public TimeValue(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private HashMap<String, ArrayList<TimeValue>> map;

    public TimeBasedKeyValueStore() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<>());

        ArrayList<TimeValue> list = map.get(key);
        list.add(new TimeValue(timestamp, value));
    }

    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        ArrayList<TimeValue> list = map.get(key);

        return getClosestValue(list, timestamp);
    }

    public String getClosestValue(
            ArrayList<TimeValue> list, int timestamp) {

        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = list.get(mid).timestamp;

            if (midValue == timestamp) {
                return list.get(mid).value;
            } else if (midValue < timestamp) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (high < 0) {
            return "";
        }

        return list.get(high).value;
    }

    public static void main(String[] args) {
        TimeBasedKeyValueStore timeMap = new TimeBasedKeyValueStore();

        timeMap.set("foo", "bar", 1);
        timeMap.set("foo", "bar2", 4);

        System.out.println(timeMap.get("foo", 1)); // bar
        System.out.println(timeMap.get("foo", 3)); // bar
        System.out.println(timeMap.get("foo", 4)); // bar2
        System.out.println(timeMap.get("foo", 5)); // bar2
        System.out.println(timeMap.get("foo", 0)); // ""
    }

}
