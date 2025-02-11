package org.nick.learn.leetcode.problem20;

/**
 * 直观判断出来的解法
 *
 * 空间复杂度 O(n)
 * 时间复杂度 O(n)
 */
public class Solution1 {
    public boolean isValid(String s) {
        Character[] chars = new Character[s.length()];
        int arrayIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars[arrayIndex++] = c;
            if (arrayIndex - 2 >= 0) {
                if (')' == c) {
                    if ('(' == chars[arrayIndex - 2]) {
                        arrayIndex = arrayIndex - 2;
                        chars[arrayIndex] = null;
                    }
                }
                if (']' == c) {
                    if ('[' == chars[arrayIndex - 2]) {
                        arrayIndex = arrayIndex - 2;
                        chars[arrayIndex] = null;
                    }
                }
                if ('}' == c) {
                    if ('{' == chars[arrayIndex - 2]) {
                        arrayIndex = arrayIndex - 2;
                        chars[arrayIndex] = null;
                    }
                }
            }
        }
        return 0 == arrayIndex && null == chars[arrayIndex];
    }
}
