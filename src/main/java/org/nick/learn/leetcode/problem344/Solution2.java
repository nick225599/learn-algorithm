package org.nick.learn.leetcode.problem344;

public class Solution2 {
    /**
     * StringBuilder.reverse() 方法里的小技巧：
     * 算中间值，不再采用 n/2 而是
     * n = n - 1;
     * 1/2n = (n - 1) >> 1;
     *
     * @see StringBuilder#reverse()
     */
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = (n - 2) >> 1; i >= 0; i--) {
            int j = n - 1 - i;
            char tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
        }
    }
}
