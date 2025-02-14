package org.nick.learn.leetcode.problem32;

import java.util.Deque;
import java.util.LinkedList;

public class Solution6 implements Solution {

    /**
     * 参照官方题解写的栈解法
     *
     * 感觉计算不对 ()(() ，应该是 2 算出来应该是 4 ？
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int result = 0;
        Deque<Integer> deque = new LinkedList<>();
        deque.offerFirst(-1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                deque.offerFirst(i);
            }
            if (')' == c) {
                deque.pop();
                if (deque.isEmpty()) { // 前一个值是 (，且已被 pop
                    deque.push(i);

                } else { // 前一个值是 (，且已被 pop

                    // 怎么计算出当前长度？
                    // TODO sunchuansheng 20250214 不对啊 为啥不需要加 1 ？
                    // TODO sunchuansheng 20250214 不对啊 ()(() 不就算成 4 了？ 应该是 2 啊
                    result = Math.max(result, i - deque.peek() + 1);
                }


            }
        }
        return result;
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