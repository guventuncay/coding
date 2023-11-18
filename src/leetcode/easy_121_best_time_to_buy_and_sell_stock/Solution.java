package leetcode.easy_121_best_time_to_buy_and_sell_stock;

class Solution {

    public static void main(String[] args) {
        int expected = 5;
        int actual = maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println("(actual == expected) = " + (actual == expected));
        int expected2 = 3;
        int actual2 = maxProfit(new int[]{1, 2, 4});
        System.out.println("(actual == expected) = " + (actual2 == expected2));
        int expected3 = 2;
        int actual3 = maxProfit(new int[]{2, 4, 1});
        System.out.println("(actual == expected) = " + (actual3 == expected3));
    }

    public static int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int minBuySoFar = prices[0];
        int maxProfitSoFar = 0;

        for (int price : prices) {
            minBuySoFar = Math.min(minBuySoFar, price);
            maxProfitSoFar = Math.max(maxProfitSoFar, price - minBuySoFar);
        }

        return maxProfitSoFar;
    }

}