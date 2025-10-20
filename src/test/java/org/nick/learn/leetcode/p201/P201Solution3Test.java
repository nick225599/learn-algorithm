package org.nick.learn.leetcode.p201;

import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class P201Solution3Test {

    @Test
    void rangeBitwiseAnd() {
        Random r = new Random();
        int left = r.nextInt(1024);
        int right = 0;
        while((right = r.nextInt(2048)) <= left){
        }
        System.out.println("left:" + left);
        System.out.println("right:" + right);
        System.out.println(new P201Solution2().rangeBitwiseAnd(left, right));
        System.out.println(new P201Solution3().rangeBitwiseAnd(left, right));

        // left:548
        // right:897

        // times: 9
        // 512

        // times: 3
        // 512
    }
}