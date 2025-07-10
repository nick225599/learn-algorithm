package org.nick.learn.leetcode.p17;

import java.util.LinkedList;
import java.util.List;

public class P17Solution4 {
    private static final char[][] PHONE = new char[][]{
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

    private void dfs(String digits, int index, List<String> result, char[] tmp) {
        char[] chars = PHONE[digits.charAt(index) - '0'];
        for (char c : chars) {
            tmp[index] = c;
            if (index == digits.length() - 1) {
                result.add(new String(tmp));
            } else {
                this.dfs(digits, index + 1, result, tmp);
            }
        }
    }
}
