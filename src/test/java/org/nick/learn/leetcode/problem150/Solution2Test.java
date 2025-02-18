package org.nick.learn.leetcode.problem150;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Validate;

import static org.junit.jupiter.api.Assertions.*;

class Solution2Test {
    Solution2 solution = new Solution2();

    @Test
    public void test(){
        String[] tokens = {"2","1","+","3","*"};
        int result = solution.evalRPN(tokens);
        assertEquals(9, result);

        tokens = new String[]{"4","13","5","/","+"};
        result = solution.evalRPN(tokens);
        assertEquals(6, result);

    }

}