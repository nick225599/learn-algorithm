package org.nick.learn.leetcode.p125;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class P125Solution1Test {

    P125Solution1 solution = new P125Solution1();

    @Test
    void isPalindrome() {
        String str = "A man, a plan, a canal: Panama";
        boolean b = solution.isPalindrome(str);
        assertTrue(b);
    }
    @Test
    void isPalindrome2() {
        String str = "ab";
        boolean b = solution.isPalindrome(str);
        assertFalse(b);
    }
    @Test
    void isPalindrome3() {
        String str = ".,";
        boolean b = solution.isPalindrome(str);
        assertTrue(b);
    }
    @Test
    void isPalindrome4() {
        String str = "a.";
        boolean b = solution.isPalindrome(str);
        assertTrue(b);
    }

    @Test
    void isPalindrome5() {
        String str = "0P";
        boolean b = solution.isPalindrome(str);
        assertFalse(b);
    }
}