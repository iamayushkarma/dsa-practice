package patterns.prefix_sum;

import java.util.Arrays;

public class CorporateFlightBookings {

    /**
     * Problem : Corporate Flight Bookings
     * LeetCode : #1109
     * Link: https://leetcode.com/problems/corporate-flight-bookings/
     * Pattern : Prefix Sum
     * Difficulty : Medium
     * Date Solved: 30-Sep-2026
     * Revision : [ ] Day3 [ ] Day7 [ ] Day14
     *
     * My Approach:s
     *
     * For every booking, instead of adding seats to every flight
     * in the given range, use a difference array.
     *
     * Add seats at the starting flight.
     *
     * Subtract seats immediately after the ending flight.
     *
     * Then calculate the prefix sum of the difference array.
     *
     * The prefix sum gives the total seats reserved for each flight.
     *
     * Optimal Approach:
     *
     * Use the result array itself as a difference array.
     *
     * For a booking [first, last, seats]:
     *
     * res[first - 1] += seats
     *
     * If last < n:
     * res[last] -= seats
     *
     * The subtraction at last stops the booking from affecting
     * flights after the given range.
     *
     * After processing all bookings, calculate the prefix sum.
     *
     * Pattern Insight:
     *
     * When multiple range updates are required, instead of updating
     * every element in the range, mark only where the change starts
     * and where the change stops.
     *
     * Then use prefix sum to propagate those changes across the array.
     *
     * Mistake I Made:
     *
     * Initially tried to update every flight between first and last
     * for every booking.
     *
     * This gives O(bookings * n) time complexity.
     *
     * Time Complexity:
     *
     * O(bookings.length + n)
     *
     * Space Complexity:
     *
     * O(n)
     */
    public static int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        int len = bookings.length;

        for (int i = 0; i < len; i++) {
            int st = bookings[i][0];
            int end = bookings[i][1];
            int seats = bookings[i][2];

            res[st - 1] += seats;

            if (end < n) {
                res[end] -= seats;
            }
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += res[i];
            res[i] = sum;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(corpFlightBookings(
                        new int[][] { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } }, 5)));

        System.out.println(
                Arrays.toString(corpFlightBookings(
                        new int[][] { { 1, 2, 10 }, { 2, 2, 15 } }, 2)));
    }
}