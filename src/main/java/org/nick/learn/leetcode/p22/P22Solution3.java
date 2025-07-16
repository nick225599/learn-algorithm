package org.nick.learn.leetcode.p22;

import java.util.LinkedList;
import java.util.List;

public class P22Solution3 {

    static List<String>[] cache = new LinkedList[9];

    static {
        cache[0] = new LinkedList<>();
        cache[0].add(""); // 空字符串不能少

        cache[1] = new LinkedList<>();
        cache[1].add("()");
    }

    // dp 思想
    public List<String> generateParenthesis(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        List<String> cur = new LinkedList<>();

        // parenthesis(n) = "(" + parenthesis(a) + ")" + parenthesis(b)
        // a b 都得允许为 0
        for (int i = 0; n - i - 1 >= 0; i++) {
            List<String> lefts = generateParenthesis(i);
            List<String> rights = generateParenthesis(n - i - 1);
            for(String l: lefts){
                for(String r : rights){
                    cur.add("(" + l + ")" + r);
                }
            }
        }
        cache[n] = cur;
        return cur;
    }

}
