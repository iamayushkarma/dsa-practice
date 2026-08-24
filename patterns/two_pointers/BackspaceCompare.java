package patterns.two_pointers;

public class BackspaceCompare {

    /**
     * Problem : Backspace String Compare
     * LeetCode : #844
     * Link: https://leetcode.com/problems/backspace-string-compare/
     * Pattern : Two Pointers / String Simulation
     * Difficulty : Easy
     * Date Solved: 24-08-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     *
     * My Approach:
     * Instead of comparing the original strings directly, first
     * simulate how both strings would look after applying all
     * backspace operations.
     *
     * I used two StringBuilder objects to build the final form
     * of both strings.
     *
     * For every character:
     * - If it is a normal character, append it to the StringBuilder.
     * - If it is '#', remove the last character if the StringBuilder
     * is not empty.
     *
     * After processing both strings, compare their final forms.
     *
     *
     * Optimal Approach:
     * 1. Create a StringBuilder for s.
     * 2. Traverse s from left to right.
     * 3. Append normal characters.
     * 4. For '#', remove the previous character if one exists.
     * 5. Repeat the same process for t.
     * 6. Convert both StringBuilders to strings.
     * 7. Compare the resulting strings.
     *
     *
     * Pattern Insight:
     * String Simulation + StringBuilder
     *
     *
     * The key idea is:
     * '#' acts like a backspace, so we can directly simulate
     * the text editor using StringBuilder.
     *
     * StringBuilder is useful here because removing the last
     * character is an O(1) operation.
     *
     *
     * Time Complexity: O(n + m)
     * Space Complexity: O(n + m)
     */

    // You are given two strings s and t.
    //
    // '#' represents a backspace character.
    //
    // A backspace removes the previous character if one exists.
    //
    // Return true if both strings are equal after processing
    // all backspace characters.

    public static boolean backspaceCompare(String s, String t) {

        StringBuilder ssb = new StringBuilder();
        StringBuilder tsb = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == '#')
                if (ssb.length() > 0)
                    ssb.deleteCharAt(ssb.length() - 1);
                else
                    ssb.append(ch);
        }
        for (char ch : t.toCharArray()) {
            if (ch == '#')
                if (tsb.length() > 0)
                    tsb.deleteCharAt(tsb.length() - 1);
                else
                    tsb.append(ch);
        }
        return ssb.toString().equals(tsb.toString());
    }

    public static void main(String[] args) {

        String s = "ab##";
        String t = "c#d#";

        System.out.println(backspaceCompare(s, t));
    }
}