package leetcode.medium_33_search_in_rotated_sorted_array;

class Solution {
    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(search(new int[]{1, 3}, 1));
        System.out.println(search(new int[]{1, 3}, 2));
        System.out.println(search(new int[]{1, 3}, 3));
        System.out.println(search(new int[]{1, 3, 5}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {//left sorted
                if (target > nums[mid] || target < nums[left]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {//right sorted
                if (target < nums[mid] || target > nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}