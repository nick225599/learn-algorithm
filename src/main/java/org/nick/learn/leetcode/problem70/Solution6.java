package org.nick.learn.leetcode.problem70;


import java.util.ArrayDeque;
import java.util.Deque;

public class Solution6 {

    // 手动模拟栈，不适用记忆化优化，会超时
    // 下面有个被注释掉的记忆优化版本，时间复杂度 O(n)
    public int climbStairs(int n) {


        // 栈，用于模拟递归调用
        Deque<Pair> stack = new ArrayDeque<>(n);
        stack.push(new Pair(n, null));

        int result = 0;
        while (!stack.isEmpty()) {
            Pair cur = stack.pop();
            if (null == cur.getResult()) {
                if (cur.getParam() == 1 || cur.getParam() == 2) {
                    cur.setResult(cur.getParam());
                    stack.push(cur);
                } else {
                    stack.push(new Pair(cur.getParam() - 1, null));
                    stack.push(new Pair(cur.getParam() - 2, null));
                }
            } else {
                result += cur.getResult();
            }
        }

        return result;
    }


//    // 手动模拟栈 没写对，下午再努力思考一下
//    public int climbStairs(int n) {
//        // 栈，用于模拟递归调用
//        Deque<Integer> stack = new ArrayDeque<>(n);
//        stack.push(n);
//
//        // 结果集，用于记录每一栈的执行结果
//        Map<Integer, Integer> cache = new HashMap<>();
//        cache.put(1, 1);
//        cache.put(2, 2);
//
//        while (!stack.isEmpty()) {
//            int cur = stack.pop();
//
//            if (cache.containsKey(cur)) {
//                continue;
//            }
//
//            if (cache.containsKey(cur - 1) && cache.containsKey(cur - 2)) {
//                int result = cache.get(cur - 1) + cache.get(cur - 2);
//                cache.put(cur, result);
//            } else {
//                stack.push(cur);
//                stack.push(cur - 1);
//                stack.push(cur - 2);
//            }
//        }
//
//        return cache.get(n);
//    }

    static class Pair {
        private Integer param;
        private Integer result;

        public Pair(Integer param, Integer result) {
            this.param = param;
            this.result = result;
        }

        public Integer getParam() {
            return param;
        }

        public void setParam(Integer param) {
            this.param = param;
        }

        public Integer getResult() {
            return result;
        }

        public void setResult(Integer result) {
            this.result = result;
        }
    }
}
