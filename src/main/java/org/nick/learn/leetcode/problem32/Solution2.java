package org.nick.learn.leetcode.problem32;

import java.util.Deque;
import java.util.LinkedList;

public class Solution2 implements Solution {

    @Override
    public int longestValidParentheses(String s) {
        return 0;

        // ()(()        有效数量 2
        // ()(())       有效数量 6

        // 我居然无法把这个人类解题思考过程翻译成代码。。。无语子
        // TODO 20250211


//        int result = 0;
//        Deque<Character> charDeque = new LinkedList<>();
//
//        int tmpCount = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//
//
//            if ('(' == c) {
//                charDeque.offerFirst(c);
//            }
//            if (')' == c) {
//                Character preChar = charDeque.peekFirst();
//                if (Character.valueOf('(').equals(preChar)) {
//                    charDeque.removeFirst();
//                    tmpCount += 2;
//
//                    if (result < tmpCount) {
//                        result = tmpCount;
//                    }
//                }else{
//
//                }
//            }
//
////                // 如果前一个值是 null，直接往里塞，计数器不变
////                if (null == preChar) {
////                    charDeque.offerFirst(c);
////                }
////                // 如果前一个值是 (，直接往里塞，计数器不做处理
////                if (Character.valueOf('(').equals(preChar)) {
////                    charDeque.offerFirst(c);
////                }
////
////                // 如果前一个值是 ) 则前面是非法格式，重新计数，当前值还是要塞进去
////                if (Character.valueOf(')').equals(preChar)) {
////                    charDeque.offerFirst(c);
////                }
//
////            }
////            if (')' == c) {
////                // 如果前一个值是 null，重新计数
////                if (null == preChar) {
////                }
////                // 如果前一个值是 (，删除这一对括号，有效值 + 2
////                if (Character.valueOf('(').equals(preChar)) {
////                    charDeque.removeFirst();
////                    tmpCount += 2;
////
////                    if (result < tmpCount) {
////                        result = tmpCount;
////                    }
////
////                }
////
////                // 如果前一个值是 )，重新计数，当前值塞进去
////                if (Character.valueOf(')').equals(preChar)) {
////
////                }
////
////
////            }
//        }
//
//        return result;
    }
}
