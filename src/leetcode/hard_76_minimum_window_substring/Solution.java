package leetcode.hard_76_minimum_window_substring;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        System.out.println("minWindow(\"ADOBECODEBANC\", \"ABC\") = " + minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("minWindow(\"a\", \"a\") = " + minWindow("a", "a"));
        System.out.println("minWindow(\"A\", \"B\") = " + minWindow("A", "B"));
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char x : t.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int minLen = s.length() + 1;
        int subStr = 0;

        int have = 0;
        int need = map.size();

        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            char rChar = s.charAt(right);
            if (map.containsKey(rChar)) {
                map.put(rChar, map.get(rChar) - 1);
                if (map.get(rChar) == 0) {
                    have++;
                }
            }

            while (have == need) {
                if (minLen > right - left + 1) {
                    minLen = right - left + 1;
                    subStr = left;
                }
                char deleted = s.charAt(left++);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) have--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
    }
}