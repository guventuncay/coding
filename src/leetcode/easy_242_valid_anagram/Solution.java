package leetcode.easy_242_valid_anagram;

import java.util.HashMap;

class Solution {

    public static void main(String[] args) {
        System.out.println("isAnagram(\"car\", \"rat\") = " + isAnagram("car", "rat"));
        System.out.println("isAnagram(\"anagram\", \"nagaram\") = " + isAnagram("anagram", "nagaram"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        return map.values().stream().allMatch(d -> d.equals(0));
    }
}