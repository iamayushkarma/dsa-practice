package patterns.binary_search;

public class KokoEatingBananas {
    /*
     * Problem : Koko Eating Bananas
     * LeetCode : #875
     * Link:
     * https://leetcode.com/problems/koko-eating-bananas/
     * Pattern : Binary Search on Answer
     * Difficulty : Medium
     * Date Solved: 03-06-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:
     * Used Binary Search on the eating speed.
     *
     * - The minimum possible speed is 1 banana/hour.
     * - The maximum possible speed is the largest pile,
     * because Koko never needs to eat faster than the
     * biggest pile in one hour.
     *
     * - Binary search between [1, maxPile].
     *
     * - For each speed (mid):
     * Calculate total hours needed to eat all bananas.
     *
     * - For every pile:
     * hours += ceil(pile / speed)
     *
     * - If total hours <= h:
     * This speed works, so try finding a smaller
     * valid speed.
     *
     * - Otherwise:
     * Speed is too slow, search on the right.
     *
     * Why It Works:
     * If Koko can finish all bananas at speed K,
     * then she can also finish at any speed > K.
     *
     * This creates a monotonic search space:
     *
     * Invalid -> Invalid -> Valid -> Valid
     *
     * which allows Binary Search on the answer.
     *
     * Pattern Insight:
     * Binary Search on Answer.
     *
     * Instead of searching for an index,
     * search for the minimum eating speed that
     * satisfies the given condition.
     *
     * Key observation:
     * As eating speed increases,
     * total hours required decreases.
     *
     * Mistakes I Made:
     * - Used '%' (modulo) instead of calculating
     * required hours.
     *
     * - Tried comparing remainder values with h.
     *
     * - Returned immediately when hours == h,
     * forgetting that a smaller valid speed
     * might still exist.
     *
     * - Used int for total hours, causing integer
     * overflow on large test cases.
     *
     * - Learned to use long for accumulated hours.
     *
     * Time Complexity: O(n * log(maxPile))
     * Space Complexity: O(1)
     */

    // Koko loves bananas and has n piles.
    // Return the minimum integer eating speed k
    // such that she can finish all bananas within h hours.
    // Helper function

    // Helper function
    public static long calPossibleK(int[] piles, int speed) {
        long hours = 0;

        for (int pile : piles) {
            hours += (pile - 1L) / speed + 1;
        }

        return hours;
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int num : piles) {
            high = Math.max(high, num);
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            long possibleK = calPossibleK(piles, mid);
            if (possibleK <= h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = { 30, 11, 23, 4, 20 };
        int h = 4;
        System.out.println(
                "Minimum integer k such that she can eat all the bananas within h hours is: " + minEatingSpeed(arr, h));
    }
}