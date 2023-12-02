package leetcode.medium_424_longest_repeating_character_replacement;

class Solution {

    public static void main(String[] args) {
        System.out.println("characterReplacement(\"ABAB\",2) = " + characterReplacement("ABAB", 2));
        System.out.println("characterReplacement(\"AABABBA\",1) = " + characterReplacement("AABABBA", 1));
    }


    public static int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int max = 0;

        int left = 0;
        int localMax = 0;
        for (int right = 0; right < s.length(); right++) {
            char rChar = (char) (s.charAt(right) - 'A');
            char lChar = (char) (s.charAt(left) - 'A');
            map[rChar]++;

            localMax = Math.max(localMax, map[rChar]);
            if ((right - left + 1) - localMax > k) {
                map[lChar]--;
                left++;
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }

}