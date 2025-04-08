package org.nick.learn.leetcode.problem151;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Solution1 {
    /**
     * 直接反转
     * <p>
     * 时间复杂度 O(n)
     * 空间复杂度 O(n)
     */
    public String reverseWords(String s) {
        char[] charsOfS = s.toCharArray();
        int n = s.length();

        char[][] results = new char[s.length()][];
        int rowIndex = 0;
        int columnIndex = 0;
        boolean preCharIsSpace = false;
        for (int i = 0; i < n; i++) {
            char tmp = charsOfS[i];
            if (tmp == ' ') {
                if (!preCharIsSpace) {
                    rowIndex++;
                    preCharIsSpace = true;
                }
            } else {
                preCharIsSpace = false;
                if (null == results[rowIndex]) {
                    results[rowIndex] = new char[s.length() - i];
                    columnIndex = 0;
                }
                try {
                    results[rowIndex][columnIndex] = tmp;
                } catch (Exception e) {
                    log.error("rowIndex: {}, columnIndex: {}", rowIndex, columnIndex);
                    log.error(e.getMessage(), e);
                }
                columnIndex++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = results.length - 1; i >= 0; i--) {
            if (null == results[i]) {
                continue;
            }
            for (int j = 0; j < results[i].length; j++) {
                char tmp = results[i][j];
                if ('\u0000' != tmp) {
                    sb.append(tmp);
                }
            }
            sb.append(" ");
        }
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
