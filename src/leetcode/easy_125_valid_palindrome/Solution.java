package leetcode.easy_125_valid_palindrome;

class Solution {
    public static void main(String[] args) {
        String i1 = "A man, a plan, a canal: Panama";
        boolean e1 = true;
        boolean a1 = isPalindrome(i1);
        System.out.println("(actual == expected) = " + (a1 == e1));
        String i2 = "0P";
        boolean e2 = false;
        boolean a2 = isPalindrome(i2);
        System.out.println("(actual == expected) = " + (a2 == e2));
    }

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            char charAtLeft = str.charAt(left);
            char charAtRight = str.charAt(right);
            if (!Character.isLetterOrDigit(charAtLeft)) {
                left++;
            } else if (!Character.isLetterOrDigit(charAtRight)) {
                right--;
            } else {
                if (Character.toLowerCase(charAtLeft) != Character.toLowerCase(charAtRight)) {
                    return false;
                }
                left++;
                right--;
            }
        }

        return true;
    }
}