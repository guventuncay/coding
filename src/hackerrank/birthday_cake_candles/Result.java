package hackerrank.birthday_cake_candles;

import java.util.List;

class Result {

    public static void main(String[] args) {
        List<Integer> candles = List.of(3, 2, 1, 3);
        int expected = 2;
        int actual = birthdayCakeCandles(candles);
        System.out.println("actual == expected = " + (actual == expected));
    }

    public static int birthdayCakeCandles(List<Integer> candles) {
        int max = 0;
        int count = 0;

        for (Integer candle : candles) {
            if (candle > max) {
                max = candle;
                count = 1;
            } else if (candle == max) {
                count++;
            }
        }
        return count;
    }
}
