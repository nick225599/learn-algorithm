package org.nick.learn.leetcode.p0022;

import java.util.ArrayList;
import java.util.List;

public class P0022Solution2 {
    //    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/generate-parentheses/solutions/192912/gua-hao-sheng-cheng-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    static List<String>[] cache = new ArrayList[100];

    // 加了缓存，时间复杂度才能跟 Solution1 一样低，
    // 但是空间复杂度立马就上来了，是 Solution1 的 n 倍
    // 怎么看都没有什么可取之处，不知道官方题解把这个解法列出来是为了干啥......
    // AI 了一下，为了演示自顶向下的递归+缓存的 dp 思想......
    public List<String> generate(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        ArrayList<String> ans = new ArrayList<String>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c) {
                for (String left : generate(c)) {
                    for (String right : generate(n - 1 - c)) {
                        ans.add("(" + left + ")" + right);
                    }
                }
            }
        }
        cache[n] = ans;
        return ans;
    }

    public List<String> generateParenthesis(int n) {
        return generate(n);
    }


}
