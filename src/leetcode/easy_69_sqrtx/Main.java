package leetcode.easy_69_sqrtx;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        System.out.println("Expected | Actual | Result");
        solve(16, 4);
        solve(110, 10);
        solve(2147395600, 46340);
        solve(2147483647, 46340);
        solve(1, 1);
    }

    private static void solve(int input, int expected) {
        int actual = Solution.mySqrt(input);
        System.out.print(expected);
        System.out.print(" ".repeat(9 - String.valueOf(expected).length()).concat("| "));
        System.out.print(actual);
        System.out.print(" ".repeat(7 - String.valueOf(actual).length()).concat("| "));
        System.out.println(Objects.equals(actual, expected));
    }
}

class Solution {
    public static int mySqrt(int x) {
        //answer could be between 1 and x, that means we have sorted array, so binary search is the best solution
        if (x == 1) {
            return 1;
        }
        long left = 1;
        long right = x;
        long mid = x / 2;

        while (!(mid * mid <= x && (mid + 1) * (mid + 1) > x)) {
            if (mid * mid > x) {
                long temp = mid;
                mid = (left + mid) / 2;
                right = temp;
            } else {
                long temp = mid;
                mid = (right + mid) / 2;
                left = temp;
            }
        }
        return (int) mid;
    }

    public static int mySqrt2(int x) {
        long r = x;
        while (r * r > x)
            r = (r + x / r) / 2;
        return (int) r;
    }
}