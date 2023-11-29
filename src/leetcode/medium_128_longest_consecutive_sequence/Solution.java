package leetcode.medium_128_longest_consecutive_sequence;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public static void main(String[] args) {
        int expected1 = 4;
        int actual1 = longestConsecutive(new int[]{100, 4, 200, 1, 3, 2});
        System.out.println("actual1 = " + actual1);
        System.out.println("actual1 == expected1 = " + (actual1 == expected1));
        int expected2 = 9;
        int actual2 = longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1});
        System.out.println("actual2 = " + actual2);
        System.out.println("actual2 == expected2 = " + (actual2 == expected2));
        int expected3 = 4;
        int actual3 = longestConsecutive(new int[]{1, 2, 3, 6, 7, 8, 9});
        System.out.println("actual3 = " + actual3);
        System.out.println("actual3 == expected3 = " + (actual3 == expected3));
    }

    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        int max = 0;
        int localMax;

        for (Integer integer : set) {
            if (!set.contains(integer - 1)) {
                localMax = 0;
                while (set.contains(integer + localMax)) {
                    localMax++;
                }
                max = Math.max(max, localMax);
            }
        }

        return max;
    }
}