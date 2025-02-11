package org.nick.learn.leetcode.problem23;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.list.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionETest {
    SolutionE solution = new SolutionE();

    @Test
    void mergeKLists() {
        ListNode n1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode n2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode n3 = new ListNode(2, new ListNode(6));
        ListNode[] l = new ListNode[]{n1, n2, n3};
        ListNode n4 = solution.mergeKLists(l);

        StringBuilder result = new StringBuilder("" + n4.val);
        while (n4.next != null) {
            result.append(",").append(n4.next.val);
            n4 = n4.next;
        }
        assertEquals("1,1,2,3,4,4,5,6", result.toString());
    }

    @Test
    void mergeKLists2() {
        ListNode n0 = new ListNode(-10, new ListNode(-9, new ListNode(-9,
                new ListNode(-3, new ListNode(-1, new ListNode(-1, new ListNode(0)))))));
        ListNode n1 = new ListNode(-5);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(-8);
        ListNode n4 = null;
        ListNode n5 = new ListNode(-9, new ListNode(-6, new ListNode(-5,
                new ListNode(-4, new ListNode(-2, new ListNode(2, new ListNode(3)))))));
        ListNode n6 = new ListNode(-3, new ListNode(-3, new ListNode(-2,
                new ListNode(-1, new ListNode(0)))));
        ListNode[] l = new ListNode[]{n0, n1, n2, n3, n4, n5, n6};
        ListNode nResult = solution.mergeKLists(l);
        StringBuilder result = new StringBuilder("" + nResult.val);
        while (nResult.next != null) {
            result.append(",").append(nResult.next.val);
            nResult = nResult.next;
        }
        assertEquals("-10,-9,-9,-9,-8,-6,-5,-5,-4,-3,-3,-3,-2,-2,-1,-1,-1,0,0,2,3,4", result.toString());
    }


}