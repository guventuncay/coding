package leetcode.medium_2352_equal_row_and_column_pairs;

import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        solve(new int[][]{{3, 2, 1}, {1, 7, 6}, {2, 7, 7}}, 1);
        solve(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}, 3);
        solve(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 4}, {2, 4, 2, 2}, {2, 5, 2, 2}}, 3);
    }

    private static void solve(int[][] input, long expected) {
        long actual = Solution.equalPairs(input);
        System.out.println("input    = " + Arrays.deepToString(input));
        System.out.println("expected = " + expected);
        System.out.println("actual   = " + actual);
        System.out.println("result   = " + Objects.equals(actual, expected));
        System.out.println("------------------------------------------------------");
    }
}

class Solution {
    public static int equalPairs(int[][] grid) {
        int ans = 0;
        int k = 0;

        for (int l = 0; l < grid.length; l++) {
            for (int m = 0; m < grid.length; m++) {
                while (k < grid.length && grid[k][l] == grid[m][k]) {
                    k++;
                }
                if (k == grid.length) {
                    ans++;
                    System.out.print("l = " + l);
                    System.out.println(", m = " + m);
                }
                k = 0;
            }
        }

        return ans;
    }
}
/*
    [[3,1,2,2],
     [1,4,4,4],
     [2,4,2,2],
     [2,5,2,2]]


 */