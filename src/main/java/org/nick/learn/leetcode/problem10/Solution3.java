package org.nick.learn.leetcode.problem10;

public class Solution3 {

    // 递归试试 TODO nick 立马下班，明天再看怎么用递归实现
    public boolean isMatch(String s, String p) {
            if (p.isEmpty()) {
                return s.isEmpty();
            }
            boolean firstMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

            if (p.length() >= 2 && p.charAt(1) == '*') {
                return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
            } else {
                return firstMatch && isMatch(s.substring(1), p.substring(1));
            }
//        if (s.isEmpty()) {
//            return p.isEmpty();
//        } else {
//            if (p.isEmpty()) {
//                return false;
//            }
//        }
//
//
//        // 字母加 * 号的模式匹配
//        if (p.length() > 1 && p.charAt(1) == '*') {
//            if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
//                if (p.length() > 2) {
//                    return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
//                } else {
//                    if(s.length() > 1 && s.charAt(0) == s.charAt(1)){
//                        return isMatch(s.substring(1), p);
//                    }else{
//                        //TODO 算了算了 迭代类的太蛮烦了
//                        // 回头再看，其实动态规划就是使用缓存来优化的递归或迭代
//                        return false;
//                    }
//
//                }
//            } else {
//                if (p.length() > 2) {
//                    return isMatch(s, p.substring(2));
//                } else {
//                    return false;
//                }
//            }
//
//        } else {
//            // 单字符串匹配
//            if (s.charAt(0) == p.charAt(0)) {
//                return isMatch(s.substring(1), p.substring(1));
//            } else {
//                return false;
//            }
//        }
    }


}
