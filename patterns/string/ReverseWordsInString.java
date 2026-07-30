package patterns.string;

public class ReverseWordsInString {
    /*
     * Problem : Reverse Words in a String
     * LeetCode : 151
     * Link:
     * https://leetcode.com/problems/reverse-words-in-a-string/
     * Pattern : String Traversal + Two Pointers
     * Difficulty : Medium
     * Date Solved: 30-07-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * I traversed the string from right to left. First, I skipped all trailing
     * and extra spaces. Then I identified each word by locating its ending and
     * starting indices. Using substring(), I appended each word directly to the
     * result. A space was added only between words to ensure the final string
     * contained exactly one space separating consecutive words.
     *
     * Optimal Approach:
     * 1. Start traversing the string from the last character.
     * 2. Skip any extra spaces.
     * 3. Mark the end of the current word.
     * 4. Move backward until the beginning of the word is found.
     * 5. Append the word to the answer.
     * 6. Repeat until all words are processed.
     *
     * Pattern Insight:
     * String Traversal
     * Two Pointers
     * Reverse Traversal
     *
     * Mistake I Made:
     * Initially, I used a fixed character variable while traversing backward,
     * which never updated and caused an infinite loop. I also used the
     * condition (st > 0), preventing index 0 from being processed correctly.
     * Finally, I forgot to skip consecutive spaces, which resulted in
     * incorrect output and infinite iterations.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     * where:
     * n = length of the input string
     */

    // Reverse the order of words in the given string.
    public static String reverseWords(String s) {

        StringBuilder sb = new StringBuilder();
        int st = s.length() - 1;

        while (st >= 0) {

            // Skip extra spaces
            while (st >= 0 && s.charAt(st) == ' ') {
                st--;
            }

            if (st < 0)
                break;

            int end = st;

            // Find the beginning of the current word
            while (st >= 0 && s.charAt(st) != ' ') {
                st--;
            }

            if (sb.length() > 0) {
                sb.append(' ');
            }

            sb.append(s.substring(st + 1, end + 1));
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "  the sky   is blue  ";

        System.out.println("Reversed String: " + reverseWords(s));
    }
}