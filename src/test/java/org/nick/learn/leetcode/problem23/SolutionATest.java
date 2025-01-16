package org.nick.learn.leetcode.problem23;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionATest {
    SolutionA solutionA = new SolutionA();
    @Test
    void mergeKLists() {


        ListNode n1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode n2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode n3 = new ListNode(2, new ListNode(6));
        ListNode[] l = new ListNode[]{n1,n2,n3};
        ListNode n4 = solutionA.mergeKLists(l);

        StringBuilder result = new StringBuilder(n4.val);
        while(n4.next != null){
            result.append(",").append(n4.next.val);
            n4 = n4.next;
        }
        assertEquals("1,1,2,3,4,4,5,6", result.toString());
        //TODO sunchuansheng 20250106 哪里边界没处理好，明天再说
        // 咋识别不了是我本人提交的代码？
    }
}