package leetcode.medium_347_top_k_frequent_element;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2)));
        System.out.println(Arrays.toString(topKFrequent(new int[]{4, 1, -1, 2, -1, 2, 3}, 2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();//num, frequency

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        var list = map.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue())) // O(n log n)
                .toList();

        return list.stream().limit(k).mapToInt(Map.Entry::getKey).toArray();
    }

}