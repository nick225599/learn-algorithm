package org.nick.learn.leetcode.p6;

public class P6Solution3 {

    // 仿照官方题解，把代码写简洁一些
    public String convert(String s, int numRows) {
        int n = s.length();
        if (n <= numRows || numRows == 1) {
            return s;
        }

        StringBuilder result = new StringBuilder();
        int period = (numRows - 1) << 1;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < n; j += period) {
                result.append(s.charAt(j));
                if (i > 0 && i < numRows - 1) {
                    int tmp = j + ((numRows - 1 - i) << 1);
                    if (tmp < n) {
                        result.append(s.charAt(tmp));
                    }
                }
            }
        }
        return result.toString();
    }
}
