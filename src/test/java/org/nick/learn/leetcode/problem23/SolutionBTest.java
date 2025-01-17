package org.nick.learn.leetcode.problem23;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.list.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionBTest {
    SolutionB solution = new SolutionB();

    @Test
    void mergeKLists() {
        ListNode n1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode n2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode n3 = new ListNode(2, new ListNode(6));
        ListNode[] l = new ListNode[]{n1,n2,n3};
        ListNode n4 = solution.mergeKLists(l);

        StringBuilder result = new StringBuilder("" + n4.val);
        while(n4.next != null){
            result.append(",").append(n4.next.val);
            n4 = n4.next;
        }
        assertEquals("1,1,2,3,4,4,5,6", result.toString());
    }
}