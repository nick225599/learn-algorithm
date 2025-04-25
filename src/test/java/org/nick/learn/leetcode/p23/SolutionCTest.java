package org.nick.learn.leetcode.p23;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.list.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class SolutionCTest {

    SolutionC solution = new SolutionC();

    @SuppressWarnings("deprecation")
    @Test
    void mergeTwoLists() {
        ListNode list1 = new ListNode(1, new ListNode(2));
        ListNode list2 = new ListNode(1, new ListNode(3));
        ListNode merged = solution.mergeTwoLists(list1, list2);
        assertEquals("1,1,2,3", merged.toStr());
    }

    @SuppressWarnings("deprecation")
    @Test
    void mergeTwoListsV2() {
        ListNode list1 = new ListNode(1, new ListNode(2));
        ListNode list2 = new ListNode(1, new ListNode(3));
        ListNode merged = solution.mergeTwoListsV2(list1, list2);
        assertEquals("1,1,2,3", merged.toStr());
    }

    @Test
    void mergeTwoListsV3() {
        ListNode list1 = new ListNode(1, new ListNode(2));
        ListNode list2 = new ListNode(1, new ListNode(3));
        ListNode merged = solution.mergeTwoListsV3(list1, list2);
        assertEquals("1,1,2,3", merged.toStr());
    }


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