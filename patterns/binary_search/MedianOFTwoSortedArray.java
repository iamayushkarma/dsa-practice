package patterns.binary_search;

import java.util.Arrays;

public class MedianOFTwoSortedArray {

    // TODO in optimal TC
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[] merge = new int[m + n];

        int idx = 0;
        int i = 0;

        while (i < n) {
            merge[idx++] = nums1[i++];
        }
        i = 0;
        while (i < m) {
            merge[idx++] = nums2[i++];
        }

        Arrays.sort(merge);

        int len = merge.length;

        if (len % 2 != 0)
            return (double) merge[len / 2];
        else
            return ((double) merge[len / 2] + merge[(len / 2) - 1]) / 2;
    }

    public static void main(String[] args) {

        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };
        findMedianSortedArrays(nums1, nums2);
    }
}