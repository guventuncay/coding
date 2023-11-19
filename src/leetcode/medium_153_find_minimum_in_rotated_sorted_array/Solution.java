package leetcode.medium_153_find_minimum_in_rotated_sorted_array;

class Solution {

    public static void main(String[] args) {
        int expected = 1;
        int actual = findMin(new int[]{3, 4, 5, 1, 2});
        System.out.println("(actual == expected) = " + (actual == expected));
        int expected2 = 1;
        int actual2 = findMin(new int[]{4, 5, 1, 2, 3});
        System.out.println("(actual == expected) = " + (actual2 == expected2));
    }

    public static int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int m;
        int res = Integer.MAX_VALUE;

        while (l <= r) {
            if (nums[l] < nums[r]) {
                return Math.min(res, nums[l]);
            }

            m = (l + r) / 2;
            res = Math.min(res, nums[m]);

            if (nums[m] >= nums[l]) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return res;
    }

}