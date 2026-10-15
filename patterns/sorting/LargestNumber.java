package patterns.sorting;

import java.sql.Array;
import java.util.*;

public class LargestNumber {
    public static String largestNumber(int[] nums) {
        String str = "";

        for (int i = 0; i < nums.length; i++) {
            str += nums[i];
        }
        return str;
    }

    public static void main(String[] args) {
        String[] arr = { "3", "30", "34", "5", "9" };
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
