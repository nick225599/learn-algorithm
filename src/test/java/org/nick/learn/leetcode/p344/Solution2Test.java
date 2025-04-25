package org.nick.learn.leetcode.p344;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution2Test {
    Solution2 solution = new Solution2();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void reverseString() {
        String str, str2;
        char[] charArr;

        str = "a";
        charArr = str.toCharArray();
        solution.reverseString(charArr);
        str2 = new String(charArr);
        assertEquals(new StringBuilder(str).reverse().toString(), str2);

        str = "ab";
        charArr = str.toCharArray();
        solution.reverseString(charArr);
        str2 = new String(charArr);
        assertEquals(new StringBuilder(str).reverse().toString(), str2);

        str = "abc";
        charArr = str.toCharArray();
        solution.reverseString(charArr);
        str2 = new String(charArr);
        assertEquals(new StringBuilder(str).reverse().toString(), str2);

        str = "abcd";
        charArr = str.toCharArray();
        solution.reverseString(charArr);
        str2 = new String(charArr);
        assertEquals(new StringBuilder(str).reverse().toString(), str2);

        str = "abcde";
        charArr = str.toCharArray();
        solution.reverseString(charArr);
        str2 = new String(charArr);
        assertEquals(new StringBuilder(str).reverse().toString(), str2);

        System.out.println("ok");
    }
}