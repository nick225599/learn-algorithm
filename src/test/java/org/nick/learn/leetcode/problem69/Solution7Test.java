package org.nick.learn.leetcode.problem69;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

class Solution7Test {
    Solution7 solution = new Solution7();
    @Test
    void test1(){
        int i = 0;

        assertEquals(1, solution.mySqrt(1));
        System.out.println("ok" + ++i);

        assertEquals(2, solution.mySqrt(4));
        System.out.println("ok" + ++i);

        assertEquals(3, solution.mySqrt(9));
        System.out.println("ok" + ++i);

        assertEquals(4, solution.mySqrt(16));
        System.out.println("ok" + ++i);

        assertEquals(5, solution.mySqrt(25));
        System.out.println("ok" + ++i);

        assertEquals(6, solution.mySqrt(36));
        System.out.println("ok" + ++i);

        assertEquals(7, solution.mySqrt(49));
        System.out.println("ok" + ++i);

        assertEquals(8, solution.mySqrt(64));
        System.out.println("ok" + ++i);

        assertEquals(9, solution.mySqrt(81));
        System.out.println("ok" + ++i);

        assertEquals(10, solution.mySqrt(100));
        System.out.println("ok" + ++i);

        assertEquals(11, solution.mySqrt(121));
        System.out.println("ok" + ++i);

        assertEquals(12, solution.mySqrt(144));
        System.out.println("ok" + ++i);

        assertEquals(13, solution.mySqrt(169));
        System.out.println("ok" + ++i);
    }

    @Test
    void test2() throws ExecutionException, InterruptedException {
        // 二分法，绝对不会出现精度误差
        Solution5 solution5 = new Solution5();

        // 浮点数运算法，可能出现精度误差
        Solution7 solution7 = new Solution7();

        ExecutorService es = Executors.newFixedThreadPool(2);
        for(int i = 0; i < Integer.MAX_VALUE; i++){
            int finalI = i;
            Future<Integer> f5 = es.submit(() -> solution5.mySqrt(finalI));
            Future<Integer> f7 = es.submit(() -> solution7.mySqrt(finalI));
            Integer r5 = f5.get();
            Integer r7 = f7.get();
            if(!r5.equals(r7)){
                System.out.println("error! i: " + i + ", r5: " + r5 + ", r7: " + r7);
            }

            if(i % 10000 == 0){
                System.out.println("ok, i: " + i);
            }
        }
        es.shutdown();
    }

}