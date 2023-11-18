package hackerrank.mini_max_sum;

import java.util.List;

public class Result {

    public static void miniMaxSum(List<Integer> arr) {
        Integer min = arr.get(0);
        Integer max = arr.get(0);

        Long sum = 0L;
        for (Integer integer : arr) {
            sum = sum + integer;
            if (integer < min) {
                min = integer;
            }
            if (integer > max) {
                max = integer;
            }
        }

        System.out.print((sum - max) + " " + (sum - min));
    }
}