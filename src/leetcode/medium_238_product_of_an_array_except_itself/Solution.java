package leetcode.medium_238_product_of_an_array_except_itself;

import java.util.Arrays;

class Solution {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;

        int prod = 1;
        for (int i = 1; i < nums.length; i++) {
            prod *= nums[i - 1];
            res[i] = prod;
        }

        prod = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            prod *= nums[i + 1];
            res[i] *= prod;
        }
        return res;
    }
}