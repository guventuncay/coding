package leetcode.medium_49_group_anagrams;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        groupAnagrams(new String[]{"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"});
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] charArray = new char[26];

            for (char c : str.toCharArray()) charArray[c - 'a']++;

            //use string as a key because char[] equals method does not return true even if they have same elements
            String key = Arrays.toString(charArray);

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}