package leetcode.medium_11_container_with_most_water;

class Solution {

    public static void main(String[] args) {
        System.out.println("maxArea(new int[]{2,3,4,5,18,17,6}) = " + maxArea(new int[]{2, 3, 4, 5, 18, 17, 6}));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}