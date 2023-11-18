package leetcode.easy_217_contains_duplicates;

import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 1};
        boolean expected = true;
        boolean actual = containsDuplicate(input);
        System.out.println("(actual == expected) = " + (actual == expected));
    }

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num))
                return true;
            set.add(num);
        }

        return false;
    }
}