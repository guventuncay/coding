package leetcode.easy_1295_find_numbers_with_even_number_of_digits;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = new int[]{12, 345, 2, 6, 7896};
        int expected = 2;
        int actual = solution.findNumbers(input);

        System.out.println("expected = " + expected);
        System.out.println("actual   = " + actual);
        System.out.println("result   = " + Objects.equals(actual, expected));
    }
}

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (((int) Math.log10(num) + 1) % 2 == 0)
                count++;
        }
        return count;
    }
}