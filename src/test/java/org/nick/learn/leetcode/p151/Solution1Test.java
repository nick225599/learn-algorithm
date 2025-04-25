package org.nick.learn.leetcode.p151;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution1Test {
    Solution1 solution = new Solution1();

    @Test
    void reverseWords() {
        String str1 = "hello world";
        String str2 =  solution.reverseWords(str1);
        assertEquals("world hello", str2);
        System.out.println("测试通过");
    }

}