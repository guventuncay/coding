package leetcode.medium_3_lonest_substring_without_repeating_characters;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        System.out.println("lengthOfLongestSubstring() = " + lengthOfLongestSubstring("abcabcbbkloi"));
        System.out.println("lengthOfLongestSubstring() = " + lengthOfLongestSubstring("abcdecefghijklmno"));
    }

    public static int lengthOfLongestSubstring(String str) {
        int max = 0;
        HashSet<Character> set = new HashSet<>();

        int p1 = 0;
        for (int i = 0; i < str.length(); i++) {
            while (set.contains(str.charAt(i))) {
                set.remove(str.charAt(p1));
                p1++;
            }
            set.add(str.charAt(i));

        }

        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        List<Character> substringL = new ArrayList<>();
        int largestlength = 0;
        for (int right = 0; right < s.length(); right++) {
            if (substringL.contains(s.charAt(right))) {
                // get the index of the char
                int index = substringL.indexOf(s.charAt(right));
                substringL.remove(index);
                if (index > 0)
                    substringL.subList(0, index).clear();
            }
            substringL.add(s.charAt(right));
            largestlength = Math.max(largestlength, substringL.size());
        }
        return largestlength;
    }
}