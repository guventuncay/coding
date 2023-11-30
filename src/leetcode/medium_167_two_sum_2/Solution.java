package leetcode.medium_167_two_sum_2;

import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        System.out.println("twoSum(new int[]{2, 7, 11, 15}, 9) = " + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (numbers[left] + numbers[right] != target) {
            if (numbers[left] + numbers[right] < target) left++;
            else right--;
        }
        return new int[]{left + 1, right + 1};
    }
}