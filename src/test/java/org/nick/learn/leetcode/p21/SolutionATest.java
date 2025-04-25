package org.nick.learn.leetcode.p21;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.list.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionATest {

    SolutionA solution = new SolutionA();

    @Test
    public void case1(){
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode merged = solution.mergeTwoLists(list1, list2);
        assertEquals("1,1,2,3,4,4", merged.toStr());
    }

    @Test
    public void case2(){
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3));
        ListNode merged = solution.mergeTwoLists(list1, list2);
        assertEquals("1,1,2,3,4", merged.toStr());
    }

}