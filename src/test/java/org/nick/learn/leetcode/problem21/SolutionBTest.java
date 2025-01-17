package org.nick.learn.leetcode.problem21;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.list.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionBTest {
    SolutionB solution = new SolutionB();

    @Test
    public void case1(){
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode merged = solution.mergeTwoLists(list1, list2);
        assertEquals("1,1,2,3,4,4", merged.toStr());
    }
}