package my.palindrome;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PalindromeCheckerTest {
    @Test
    public void testIsPalindrome() {
        boolean test1 = PalindromeChecker.isPalindrome("Tenet");
        boolean test2 = PalindromeChecker.isPalindrome("A man, a plan, a canal, Panama!");
        boolean test3 = PalindromeChecker.isPalindrome("Shit");
        boolean test4 = PalindromeChecker.isPalindrome("not a palindrome");

        System.out.println("Test 1 - Is 'Tenet' a palindrome? " + test1);
        System.out.println("Test 2 - Is 'A man, a plan, a canal, Panama!' a palindrome? " + test2);
        System.out.println("Test 3 - Is 'Shit' a palindrome? " + test3);
        System.out.println("Test 4 - Is 'not a palindrome' a palindrome? " + test4);


    }
}