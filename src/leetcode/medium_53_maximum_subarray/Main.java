package leetcode.medium_53_maximum_subarray;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        solve(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6);
    }

    private static void solve(int[] input, int expected) {
        long actual = Solution.maxSubArray(input);
        System.out.println("input    = " + Arrays.toString(input));
        System.out.println("expected = " + expected);
        System.out.println("actual   = " + actual);
        System.out.println("result   = " + Objects.equals(actual, expected));
        System.out.println("------------------------------------------------------");
    }
}

class Solution {
    public static int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        dp[0] = A[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = A[i] + (Math.max(dp[i - 1], 0));
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}