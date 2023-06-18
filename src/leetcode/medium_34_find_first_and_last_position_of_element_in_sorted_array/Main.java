package leetcode.medium_34_find_first_and_last_position_of_element_in_sorted_array;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        solve(new int[]{5, 7, 7, 8, 8, 10}, 8, new int[]{3, 4});
        solve(new int[]{5, 7, 7, 8, 8, 10}, 6, new int[]{-1, -1});
        solve(new int[]{}, 8, new int[]{-1, -1});
        solve(new int[]{1}, 1, new int[]{0, 0});
        solve(new int[]{2, 2}, 2, new int[]{0, 1});
        solve(new int[]{1, 3}, 1, new int[]{0, 0});

    }

    private static void solve(int[] input, int target, int[] expected) {
        System.out.println("input    = " + Arrays.toString(input));
        System.out.println("target   = " + target);
        System.out.println("expected = " + Arrays.toString(expected));
        int[] actual = Solution.searchRange(input, target);
        System.out.println("actual   = " + Arrays.toString(actual));
        System.out.println("result   = " + Arrays.equals(actual, expected));
        System.out.println("------------------------------------------------------");
    }
}

class Solution {
    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            if (target == nums[0]) {
                return new int[]{0, 0};
            } else return new int[]{-1, -1};
        }
        int idx = binarySearch(nums, target);
        if (idx == -1) {
            return new int[]{-1, -1};
        }
        int a = idx;
        int b = idx;
        while (a - 1 >= 0 && target == nums[a - 1]) {
            a--;
        }
        while (b + 1 <= nums.length - 1 && target == nums[b + 1]) {
            b++;
        }
        return new int[]{a, b};
    }

    static int binarySearch(int[] arr, int x) {
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            if (arr[m] == x)
                return m;

            if (arr[m] < x)
                l = m + 1;

            else
                r = m - 1;
        }
        return -1;
    }
}