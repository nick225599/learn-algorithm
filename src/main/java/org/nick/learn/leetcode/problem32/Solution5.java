package org.nick.learn.leetcode.problem32;

import java.util.Deque;
import java.util.LinkedList;


public class Solution5 implements Solution {

    /**
     * 官方题解，栈
     */
    @Override
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

//    /**
//     * Q: sunchuansheng 20250214 怎么用栈一次遍历解决问题？
//     * A: 我们始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」
//     */
//    public int longestValidParentheses(String s) {
//        int result = 0;
//        Deque<Integer> deque = new LinkedList<>();
//        deque.offerFirst(-1);
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if('(' == c){
//                deque.offerFirst(i);
//            }
//            if(')' == c){
//                // 如果前一个是 ( 直接删掉这个 ( 就行
//                // 然后计算和前一个 C 之间的长度
//                // 如果比 result 大，就更新 result
//
//                // 如果前一个是 )，那么就把当前 ) 的位置替换掉前一个 ) 的位置
//
//                // 怎么判断前一个是 ( 还是 ) 呢？
//                // size() == 1 前一个是 )
//                // size() > 1 前一个是 (
//
//                if(deque.size() == 1){
//                    deque.pollLast();
//                    deque.offerFirst(i);
//                }
//                if(deque.size() > 1){
//                    Integer preIndex = deque.pollFirst();
//                    int validLength = i - preIndex + 1;
//                    result = Math.max(result, validLength);
//                }
//            }
//        }
//        return result;
//    }


}