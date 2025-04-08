package org.nick.learn.leetcode.problem344;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class Solution1Test {


    private Solution1 solution = new Solution1();

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void reverseString() {
        String str1 = "abcdefg";
        char[] charArray = str1.toCharArray();
        solution.reverseString(charArray);
        String str2 = new String(charArray);
        assertEquals(new StringBuilder(str1).reverse().toString(), str2);
        System.out.println("测试通过");
    }
}