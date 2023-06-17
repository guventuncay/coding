package leetcode.medium_2708_maximum_strength_of_a_group;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        solve(new int[]{3, -1, -5, 2, 5, -9}, 1350);
        solve(new int[]{-4, -5, -4}, 20);
        solve(new int[]{0, -1}, 0);
        solve(new int[]{-9}, -9);
        solve(new int[]{3, -2}, 3);
        solve(new int[]{0, -5, 0}, 0);
        solve(new int[]{6, -3, -4, 8, 4, 7, 6, 4, 7, 7, -3, -6, 9}, 3072577536L);
    }

    private static void solve(int[] input, long expected) {
        long actual = Solution.maxStrength(input);
        System.out.println("input    = " + Arrays.toString(input));
        System.out.println("expected = " + expected);
        System.out.println("actual   = " + actual);
        System.out.println("result   = " + Objects.equals(actual, expected));
        System.out.println("------------------------------------------------------");
    }
}

class Solution {
    public static long maxStrength(int[] nums) {
        long str = 0;
        int lowestNegative = Integer.MIN_VALUE;
        boolean anyp = false;
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            if (nums[0] < 0 && nums[1] < 0) {
                return (long) nums[0] * nums[1];
            }
            if (nums[0] < 0) {
                return nums[1];
            }
            if (nums[1] < 0) {
                return nums[0];
            }
        }
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (num > 0) {
                anyp = true;
            }
            if (str != 0) {
                anyp = true;
                str *= num;
            } else {
                str = num;
            }
            if (num < 0 && lowestNegative < num) {
                lowestNegative = num;
            }
        }
        if (str < 0) {
            str /= lowestNegative;
        }
        return anyp ? str : 0;
    }
}