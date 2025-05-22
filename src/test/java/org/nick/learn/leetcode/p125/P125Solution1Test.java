package org.nick.learn.leetcode.p125;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class P125Solution1Test {

    P125Solution1 solution = new P125Solution1();

    @Test
    void isPalindrome() {
        String str = "A man, a plan, a canal: Panama";
        boolean b = solution.isPalindrome(str);
        assertTrue(b);
    }
}