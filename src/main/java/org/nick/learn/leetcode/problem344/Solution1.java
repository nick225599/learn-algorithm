package org.nick.learn.leetcode.problem344;

public class Solution1 {
    /**
     * 顺序遍历反转
     * 时间复杂度O(n)
     */
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < (n / 2); i++) {
            char tmp = s[i];
            s[i] = s[n - 1 - i];
            s[n - 1 - i] = tmp;
        }
        System.out.println("after reverse: " + new String(s));

    }
}
