package my.palindrome;

public class PalindromeChecker {
    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        str = str.replaceAll("[^a-z0-9]", "");
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}