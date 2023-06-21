package leetcode.medium_152_maximum_product_subarray;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        solve(new int[]{2, 3, -2, 4}, 6);
        solve(new int[]{-2, 0, -1}, 0);
    }

    private static void solve(int[] input, long expected) {
        long actual = Solution.maxProduct(input);
        System.out.println("input    = " + Arrays.toString(input));
        System.out.println("expected = " + expected);
        System.out.println("actual   = " + actual);
        System.out.println("result   = " + Objects.equals(actual, expected));
        System.out.println("------------------------------------------------------");
    }
}

class Solution {
    public static int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = max;

            max = Math.max(Math.max(max * nums[i], min * nums[i]), nums[i]);
            min = Math.min(Math.min(temp * nums[i], min * nums[i]), nums[i]);

            if (max > ans) {
                ans = max;
            }
        }
        return ans;
    }
}
