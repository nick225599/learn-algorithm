package org.nick.learn.leetcode.p6;

public class P6Solution1 {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (n <= numRows || numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(s.charAt(i));
            int tmp = 0;
            for (int j = i; j < n; ) {
                tmp ^= 1;
                int diff;
                if (tmp == 1) {
                    diff = ((numRows - 1 - i) << 1);
                } else {
                    diff = (i << 1);
                }
                if (diff == 0) {
                    continue;
                }
                j += diff;
                if (j < n) {
                    sb.append(s.charAt(j));
                }
            }
        }
        return sb.toString();
    }
}
