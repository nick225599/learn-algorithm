package org.nick.learn.leetcode.p17;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P17Solution1 {
    char[][] phone = new char[][]{
            null, null,
            new char[]{'a', 'b', 'c'},
            new char[]{'d', 'e', 'f'},
            new char[]{'g', 'h', 'i'},
            new char[]{'j', 'k', 'l'},
            new char[]{'m', 'n', 'o'},
            new char[]{'p', 'q', 'r', 's'},
            new char[]{'t', 'u', 'v'},
            new char[]{'w', 'x', 'y', 'z'},

    };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new LinkedList<>();
        }
        List<String> result = new LinkedList<>();
        this.dfs(digits, 0, result, new char[digits.length()]);
        return result;
    }

    // 以 String 作为入参，GC 压力有点大啊
    private void dfs(String digits, int index, List<String> result, char[] tmp) {
        char[] chars = phone[digits.charAt(index) - '0'];
        for (char c : chars) {
            if (index == digits.length() - 1) {
                tmp[index] = c;
                result.add(new String(tmp));
            } else {
                char[] newTmp = Arrays.copyOf(tmp, tmp.length);
                newTmp[index] = c;
                this.dfs(digits, index + 1, result, newTmp);
            }
        }
    }
}
