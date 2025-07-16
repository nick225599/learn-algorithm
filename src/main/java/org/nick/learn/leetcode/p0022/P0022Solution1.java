package org.nick.learn.leetcode.p0022;

import java.util.LinkedList;
import java.util.List;

public class P0022Solution1 {
    // 0ms 击败 100%
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        this.backstrace(ans, n, new char[(n << 1)], 0, 0, 0);
        return ans;
    }

    private void backstrace(List<String> ans, int n, char[] chars, int insertPos, int lSum, int rSum) {
        if (insertPos == n << 1) {
            ans.add(new String(chars));
        }

        boolean canInsertLeft = lSum < n;
        if (canInsertLeft) {
            chars[insertPos] = '(';
            backstrace(ans, n, chars, insertPos + 1, lSum + 1, rSum);
        }

        boolean canInsertRight = lSum != rSum;
        if(canInsertRight){
            chars[insertPos] = ')';
            backstrace(ans, n, chars, insertPos + 1, lSum, rSum + 1);
        }
    }
}
