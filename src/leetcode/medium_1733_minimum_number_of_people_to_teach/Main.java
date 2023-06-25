package leetcode.medium_1733_minimum_number_of_people_to_teach;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        solve(2, new int[][]{{1}, {2}, {1, 2}}, new int[][]{{1, 2}, {1, 3}, {2, 3}}, 1);
        solve(2, new int[][]{{2}, {1, 3}, {1, 2}, {3}}, new int[][]{{1, 4}, {1, 2}, {3, 4}, {2, 3}}, 2);
        solve(11, new int[][]{{3, 11, 5, 10, 1, 4, 9, 7, 2, 8, 6}, {5, 10, 6, 4, 8, 7}, {6, 11, 7, 9}, {11, 10, 4}, {6, 2, 8, 4, 3}, {9, 2, 8, 4, 6, 1, 5, 7, 3, 10}, {7, 5, 11, 1, 3, 4}, {3, 4, 11, 10, 6, 2, 1, 7, 5, 8, 9}, {8, 6, 10, 2, 3, 1, 11, 5}, {5, 11, 6, 4, 2}},
                new int[][]{{7, 9}, {3, 7}, {3, 4}, {2, 9}, {1, 8}, {5, 9}, {8, 9}, {6, 9}, {3, 5}, {4, 5}, {4, 9}, {3, 6}, {1, 7}, {1, 3}, {2, 8}, {2, 6}, {5, 7}, {4, 6}, {5, 8}, {5, 6}, {2, 7}, {4, 8}, {3, 8}, {6, 8}, {2, 5}, {1, 4}, {1, 9}, {1, 6}, {6, 7}},
                0);
    }

    private static void solve(int n, int[][] languages, int[][] friendships, long expected) {
        long actual = Solution.minimumTeachings(n, languages, friendships);
        System.out.println("n         = " + n);
        System.out.println("languages = " + Arrays.deepToString(languages));
        System.out.println("friends   = " + Arrays.deepToString(friendships));
        System.out.println("expected  = " + expected);
        System.out.println("actual    = " + actual);
        System.out.println("result    = " + Objects.equals(actual, expected));
        System.out.println("------------------------------------------------------");
    }
}

class Solution {
    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {

        Map<Integer, Set<Integer>> langSpeakersMap = new HashMap<>();

        for (int i = 0; i < languages.length; i++) {
            int[] langs = languages[i];
            for (int lang : langs) {
                if (langSpeakersMap.get(lang) == null) {
                    HashSet<Integer> speakersSet = new HashSet<>();
                    speakersSet.add(i + 1);
                    langSpeakersMap.put(lang, speakersSet);
                } else {
                    langSpeakersMap.get(lang).add(i + 1);
                }
            }
        }

        Set<Integer> usersWhoCannotComEachOther = new HashSet<>();

        for (int[] friendship : friendships) {
            int user1 = friendship[0];
            int user2 = friendship[1];
            boolean found = false;
            for (int i = 0; i < languages[user1 - 1].length; i++) {//langs spoken by user1
                int lang = languages[user1 - 1][i];
                if (langSpeakersMap.get(lang).contains(user2)) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                Collections.addAll(usersWhoCannotComEachOther, user1, user2);
            }
        }

        int ans = Integer.MAX_VALUE;

        for (Map.Entry<Integer, Set<Integer>> entry : langSpeakersMap.entrySet()) {
            Set<Integer> value = entry.getValue();
            int counter = 0;
            for (Integer u : usersWhoCannotComEachOther) {
                if (!value.contains(u)) {
                    counter++;
                }
            }
            ans = Math.min(ans, counter);
        }

        return ans;
    }
}
/*
        {{3,11,5,10,1,4,9,7,2,8,6},{5,10,6,4,8,7},{6,11,7,9},{11,10,4},{6,2,8,4,3},{9,2,8,4,6,1,5,7,3,10},{7,5,11,1,3,4},{3,4,11,10,6,2,1,7,5,8,9},{8,6,10,2,3,1,11,5},{5,11,6,4,2}}

        {{7,9},{3,7},{3,4},{2,9},{1,8},{5,9},{8,9},{6,9},{3,5},{4,5},{4,9},{3,6},{1,7},{1,3},{2,8},{2,6},{5,7},{4,6},{5,8},{5,6},{2,7},{4,8},{3,8},{6,8},{2,5},{1,4},{1,9},{1,6},{6,7}}



 */