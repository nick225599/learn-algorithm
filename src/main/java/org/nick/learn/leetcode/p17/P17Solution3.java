package org.nick.learn.leetcode.p17;

import java.util.ArrayList;
import java.util.List;

public class P17Solution3 {
    // 民间击败 99% 解法

    public List<String> letterCombinations(String digits) {
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int n = digits.length();
        List<String> ans = new ArrayList<>();
        if (n == 0) return ans;
        char[] path = new char[n];
        letterCombinationsDps(ans, map, path, digits, 0);
        return ans;
    }

    public static void letterCombinationsDps(List<String> ans, String[] map, char[] path, String digits, int i) {
        if (i == path.length) {
            ans.add(String.valueOf(path));
            return;
        }
        String letters = map[digits.toCharArray()[i] - '0'];
        for (char c : letters.toCharArray()) {
            path[i] = c; // 欸？ 不需要复制数组？
            letterCombinationsDps(ans, map, path, digits, i + 1);
        }
    }

}
