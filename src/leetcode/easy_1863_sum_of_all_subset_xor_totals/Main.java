package leetcode.easy_1863_sum_of_all_subset_xor_totals;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        solve(new int[]{1, 3}, 6);
        solve(new int[]{5, 1, 6}, 28);
        solve(new int[]{3, 4, 5, 6, 7, 8}, 480);
    }

    private static void solve(int[] input, long expected) {
        long actual = Solution.subsetXORSum(input);
        System.out.println("input    = " + Arrays.toString(input));
        System.out.println("expected = " + expected);
        System.out.println("actual   = " + actual);
        System.out.println("result   = " + Objects.equals(actual, expected));
        System.out.println("------------------------------------------------------");
    }
}

class Solution {
    public static int subsetXORSum(int[] nums) {
        return helper(nums, 0, 0);
    }

    private static int helper(int[] nums, int index, int crrXOR) {
        if (index == nums.length) return crrXOR;

        int include = helper(nums, index + 1, crrXOR ^ nums[index]);

        int exclude = helper(nums, index + 1, crrXOR);

        return include + exclude;
    }
}

// 010 XOR 101 XOR 110 =
// 111 XOR 110 = 001