package patterns.string;

public class CountAndSay {
    /*
     * Problem : Count and Say
     * LeetCode : 38
     * Link:
     * https://leetcode.com/problems/count-and-say/
     * Pattern : Recursion + String Traversal
     * Difficulty : Medium
     * Date Solved: 30-07-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * I solved the problem recursively. For each value of n, I first generated
     * the result for (n - 1). Then, I traversed that string and counted
     * consecutive occurrences of each character. Whenever a different character
     * was encountered, I appended the frequency followed by the character to
     * construct the next sequence.
     *
     * Optimal Approach:
     * 1. If n == 1, return "1".
     * 2. Recursively generate the previous sequence (n - 1).
     * 3. Traverse the previous sequence from left to right.
     * 4. Count consecutive identical characters.
     * 5. Append the count followed by the character to the answer.
     * 6. Return the newly constructed sequence.
     *
     * Pattern Insight:
     * Recursion
     * String Traversal
     * Run-Length Encoding (RLE)
     *
     * Mistake I Made:
     * Initially, I found it difficult to identify when to stop counting a group
     * of identical characters. The key observation was to continue counting
     * while the current character matches the next one, then append the count
     * and character only once before moving to the next group.
     *
     * Time Complexity: O(L)
     * Space Complexity: O(L)
     *
     * where:
     * L = length of the generated Count-and-Say sequence for the given n.
     *
     * Note:
     * Although the solution uses recursion with n recursive calls, the dominant
     * cost is traversing and constructing the generated string at each level.
     * Since n <= 30, recursion depth is small and acceptable.
     */

    // Generate the nth term of the Count-and-Say sequence.
    public static String countAndSay(int n) {

        if (n == 1)
            return "1";

        String say = countAndSay(n - 1);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < say.length(); i++) {

            char ch = say.charAt(i);
            int count = 1;

            while (i < say.length() - 1 && say.charAt(i) == say.charAt(i + 1)) {
                count++;
                i++;
            }

            sb.append(count);
            sb.append(ch);
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println("Count and Say Sequence: " + countAndSay(n));
    }
}