package org.nick.learn.leetcode.p9;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class P9Solution2 {
    // 不进阶，一遍过
    // 进阶：你能不将整数转为字符串来解决这个问题吗？
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int tmp = 0;
        while (tmp < x) {
            tmp = 10 * tmp + x % 10;
            x = x / 10;
        }
        return tmp == x || tmp / 10 == x;
    }

}
