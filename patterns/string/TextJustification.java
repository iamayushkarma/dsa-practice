package patterns.string;

import java.util.*;

public class TextJustification {

    /**
     * Problem: Text Justification
     * LeetCode Number: 68
     * Link: https://leetcode.com/problems/text-justification/
     * Pattern: Greedy / String Manipulation
     * Difficulty: Hard
     * Date Solved: 24-Nov-2026
     *
     * Revision: [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * - Greedily collect words that can fit in the current line.
     * - Track the total character length of collected words.
     * - Calculate available spaces after determining the line.
     * - Distribute spaces evenly between words.
     * - Distribute remaining spaces from left to right.
     * - Handle the last line separately using single spaces
     * between words and trailing spaces at the end.
     *
     * Optimal Approach:
     * - Greedy line construction.
     * - Calculate the required spaces for each line.
     * - Distribute spaces evenly, prioritizing left gaps
     * when the distribution is uneven.
     *
     * Pattern Insight:
     * - First determine which words fit in a line.
     * - Minimum spaces between words are one.
     * - Extra spaces are distributed evenly.
     * - Remaining spaces go to the leftmost gaps.
     * - The last line is left-justified.
     *
     * Mistake I Made:
     * - No specific mistake recorded.
     *
     * Time Complexity: O(n + L * k)
     * Space Complexity: O(L * k)
     *
     * n = total number of words
     * L = maxWidth
     * k = number of output lines
     */

    public static List<String> fullJustify(String[] words, int maxWidth) {

        List<String> res = new ArrayList<>();
        ArrayList<String> line = new ArrayList<>();

        int length = 0;
        int i = 0;

        while (i < words.length) {

            if (length + line.size() + words[i].length() > maxWidth) {

                int extraSpace = maxWidth - length;
                int spaces = extraSpace / Math.max(1, line.size() - 1);
                int remainder = extraSpace % Math.max(1, line.size() - 1);

                for (int j = 0; j < Math.max(1, line.size() - 1); j++) {

                    line.set(j, line.get(j) + " ".repeat(spaces));

                    if (remainder > 0) {
                        line.set(j, line.get(j) + " ");
                        remainder--;
                    }
                }

                res.add(String.join("", line));

                line = new ArrayList<>();
                length = 0;
            }

            line.add(words[i]);
            length += words[i].length();
            i++;
        }

        // Last line
        String lastLine = String.join(" ", line);
        int trailSpace = maxWidth - lastLine.length();

        res.add(lastLine + " ".repeat(trailSpace));

        return res;
    }

    public static void main(String[] args) {

        // Test Case 1
        String[] words1 = {
                "This", "is", "an", "example", "of", "text", "justification."
        };

        List<String> result1 = fullJustify(words1, 16);

        assert result1.equals(Arrays.asList(
                "This    is    an",
                "example  of text",
                "justification.  "));

        // Test Case 2
        String[] words2 = {
                "What", "must", "be", "acknowledgment", "shall", "be"
        };

        List<String> result2 = fullJustify(words2, 16);

        assert result2.equals(Arrays.asList(
                "What   must   be",
                "acknowledgment  ",
                "shall be        "));

        // Test Case 3
        String[] words3 = {
                "Science", "is", "what", "we", "understand", "well",
                "enough", "to", "explain", "to", "a", "computer.",
                "Art", "is", "everything", "else", "we", "do"
        };

        List<String> result3 = fullJustify(words3, 20);

        assert result3.size() == 6;
        for (String str : result3) {
            assert str.length() == 20;
        }

        System.out.println("All test cases passed!");
    }
}