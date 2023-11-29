package leetcode.medium_271_encode_and_decode_strings;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<String> lint = List.of("lint", "code", "love", "you");
        String encode = encode(lint);
        System.out.println("encode() = " + encode);
        System.out.println("decode(encode) = " + decode(encode));

    }


    public static String encode(List<String> strs) {
        StringBuilder joiner = new StringBuilder();
        for (String str : strs) {
            joiner.append(str.length()).append('$').append(str);
        }
        return joiner.toString();
    }

    public static List<String> decode(String str) {

        ArrayList<String> list = new ArrayList<>();

        char[] carr = str.toCharArray();

        int l = 0;
        StringBuilder fn = new StringBuilder();
        while (l < carr.length) {
            char c = carr[l];
            if (c != '$') {
                fn.append(c);
            } else {
                int integer = Integer.parseInt(fn.toString());
                fn.delete(0, fn.length());
                String substring = str.substring(l + 1, l + 1 + integer);
                list.add(substring);
                l = l + integer;
            }
            l++;
        }
        return list;
    }

}