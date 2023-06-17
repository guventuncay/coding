package leetcode.easy_1313_decompress_run_length_encoded_list;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {1, 1, 2, 3};
        int[] expected = {1, 3, 3};
        int[] actual = solution.decompressRLElist(input);

        System.out.println("expected = " + Arrays.toString(expected));
        System.out.println("actual   = " + Arrays.toString(actual));
        System.out.println("result   = " + Arrays.equals(actual, expected));
    }
}

class Solution {
    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                res.add(nums[i + 1]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}