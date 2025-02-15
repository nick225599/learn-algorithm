package org.nick.learn.leetcode.problem32;

import java.util.Deque;
import java.util.LinkedList;

public class Solution7 implements Solution {

    /**
     * 参照官方题解写的栈解法
     * <p>
     * 感觉计算不对 ()(() ，应该是 2 算出来应该是 4 ？
     *
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);

        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                stack.push(i);
            }
            if (')' == c) {
                if (-1 == stack.peek()) {
                    stack.push(i);
                } else {
                    // ()(()) 为啥是 2？ 而不是 6 ？
                    // 这里不能取字符串前一个值
                    // 而是上一个未能被匹配上的字符
//                    char preChar = s.charAt(i - 1);
                    char preNotPairedChar = s.charAt(stack.peek());
                    if ('(' == preNotPairedChar) {
                        stack.pop();

                        // ()) 空指针？ 所以还就真只能塞一个未匹配的 ）
                        result = Math.max(result, i - stack.peek());
                    }
                    if (')' == preNotPairedChar) {
                        stack.push(i);
                    }
                }

            }
        }
        return result;
    }

        // 写对了，思想就是在堆栈里存没能被匹配的字符的下标，
    // 一旦有字符被匹配，就用被匹配的字符下标减去最近一个未能被匹配的字符的下标，就能算出当前匹配的字符对应的有效长度了
    //todo nick_sun 20250215 再把代码简洁一下

}