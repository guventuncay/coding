package leetcode.medium_2718_sum_of_matrix_after_queries;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        solve(3, new int[][]{{0, 0, 4}, {0, 1, 2}, {1, 0, 1}, {0, 2, 3}, {1, 2, 1}}, 17);
        solve(3, new int[][]{{0, 0, 1}, {1, 2, 2}, {0, 2, 3}, {1, 0, 4}}, 23);
    }

    private static void solve(int n, int[][] queries, long expected) {
        System.out.println("n = " + n);
        System.out.println("queries = " + Arrays.deepToString(queries));
        System.out.println("expected = " + expected);
        long actual = Solution.matrixSumQueries(n, queries);
        System.out.println("actual   = " + actual);
        System.out.println("result   = " + Objects.equals(actual, expected));
        System.out.println("------------------------------------------------------");
    }
}

class Solution {
    public static long matrixSumQueries(int n, int[][] queries) {
        long sum = 0;
        int rows = n;
        int cols = n;
        Set<Integer> visitedRows = new HashSet<>();
        Set<Integer> visitedCols = new HashSet<>();
        for (int i = queries.length - 1; i >= 0; i--) {
            int[] query = queries[i];
            int opr = query[0];
            int idx = query[1];
            int val = query[2];
            if (opr == 0 && !visitedRows.contains(idx)) {
                rows--;
                visitedRows.add(idx);
                sum += (long) cols * val;
            } else if (opr == 1 && !visitedCols.contains(idx)) {
                cols--;
                visitedCols.add(idx);
                sum += (long) rows * val;
            }
        }

        return sum;
    }
}