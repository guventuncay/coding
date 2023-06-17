package leetcode.easy_1455_check_if_a_word_occurs_as_a_prefix_of_any_word_in_a_sentence;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String sentence = "i love eating burger";
        String word = "burg";
        int expected = 4;
        int actual = solution.isPrefixOfWord(sentence, word);

        System.out.println("expected = " + expected);
        System.out.println("actual   = " + actual);
        System.out.println("result   = " + Objects.equals(actual, expected));
    }
}

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] splitted = sentence.split(" ");

        for (int i = 0; i < splitted.length; i++) {
            String s = splitted[i];
            if (s.startsWith(searchWord)) {
                return i + 1;
            }
        }
        return -1;
    }
}