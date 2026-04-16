package patterns.hashing;

public class BullsAndCows {
    /*
     * Problem : Bulls and Cows
     * LeetCode : #299
     * Link: https://leetcode.com/problems/bulls-and-cows/
     * Pattern : Hashing / Counting
     * Difficulty : Medium
     * Date Solved: 16-Apr-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * First I thought of using HashMap to store positions of digits and compare
     * them.
     * But that failed because duplicates overwrite values and we lose information.
     *
     * Then I realized we don’t need positions, we just need counts.
     * So I used two frequency arrays:
     * - Count unmatched digits from secret
     * - Count unmatched digits from guess
     * Then for cows, take min of both counts.
     *
     * Optimal Approach:
     * Traverse both strings once.
     * - If digits match → bull++
     * - If not → store frequency of digits
     *
     * After traversal:
     * - For each digit (0–9), cows += min(freqSecret, freqGuess)
     *
     * This works because cows are basically common digits but in wrong positions.
     *
     * Pattern Insight:
     * This is a counting problem, not mapping problem.
     * The key idea was: ignore positions for cows, only care about frequency.
     *
     * Mistake I Made:
     * - Tried using HashMap with index → failed for duplicates
     * - Overcomplicated thinking with position mapping
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1) // only 10-size arrays
     */
    public static String bullsAndCows(String secret, String guess) {
        int[] f1 = new int[10];
        int[] f2 = new int[10];
        int bull = 0, cow = 0;

        for (int i = 0; i < secret.length(); i++) {
            int s = secret.charAt(i) - '0';
            int g = guess.charAt(i) - '0';

            if (s == g) {
                bull++;
            } else {
                f1[s]++;
                f2[g]++;
            }
        }

        for (int i = 0; i < 10; i++) {
            cow += Math.min(f1[i], f2[i]);
        }

        return bull + "A" + cow + "B";
    }

    public static void main(String[] args) {
        String str = "1123";
        String str2 = "0111";
        System.out.println(bullsAndCows(str, str2));
        ;
    }
}
