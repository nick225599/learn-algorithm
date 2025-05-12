package org.nick.learn.leetcode.p13;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class P13Solution1Test {

    P13Solution1 solution = new P13Solution1();

    //    示例 1:
//    输入: s = "III"
//    输出: 3
    @Test
    void romanToInt() {
        String s = "III";
        int i = 3;
        assertEquals(i, solution.romanToInt(s));
    }
//    示例 2:
//    输入: s = "IV"
//    输出: 4
//
//    示例 3:
//    输入: s = "IX"
//    输出: 9
//
//    示例 4:
//    输入: s = "LVIII"
//    输出: 58
//    解释: L = 50, V= 5, III = 3.
//
//    示例 5:
//    输入: s = "MCMXCIV"
//    输出: 1994
//    解释: M = 1000, CM = 900, XC = 90, IV = 4.
}