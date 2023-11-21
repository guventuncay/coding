package leetcode.easy_507_perfect_number;

class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num < 2) {
            return false;
        }

        int sq = (int) Math.sqrt(num);
        int sum = 1;

        for (int i = 2; i <= sq; i++) {
            if (num % i == 0) sum += i + (num / i);
        }

        return sum == num;
    }
}