package org.nick.learn.leetcode.p0022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class P0022Solution3 {

    static List<String>[] cache = new LinkedList[9];

    static {
        cache[0] = new LinkedList<>();
        cache[1] = new LinkedList<>();
        cache[1].add("()");
    }

    // dp 思想
    public List<String> generateParenthesis(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        List<String> cur = new LinkedList<>();
        for (int i = 1; i <= n - 1; i++) {
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
