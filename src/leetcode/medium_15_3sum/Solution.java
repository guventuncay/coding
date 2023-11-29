package leetcode.medium_15_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println("threeSum(new int[]{-1, 0, 1, 2, -1, -4}) = \n" + threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println("threeSum(new int[]{-1, 0, 1}) = \n" + threeSum(new int[]{-1, 0, 1}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        int left;
        int right;
        int target;
        int sum;
        for (int i = 0, numsLength = nums.length - 2; i < numsLength; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                right = nums.length - 1;
                target = -nums[i];
                left = i + 1;
                while (left < right) {
                    sum = nums[right] + nums[left];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        ans.add(List.of(nums[right], nums[left], -sum));
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return ans;
    }

}