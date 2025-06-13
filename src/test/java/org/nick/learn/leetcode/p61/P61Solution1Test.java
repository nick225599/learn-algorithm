package org.nick.learn.leetcode.p61;

import org.junit.jupiter.api.Test;
import org.nick.learn.algorithm.list.ListNode;

import static org.junit.jupiter.api.Assertions.*;

class P61Solution1Test {
    P61Solution1 solution = new P61Solution1();

    @Test
    void rotateRight() {
        ListNode list1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        ListNode.printListNode(list1);
        ListNode list2 = solution.rotateRight(list1, 2);
        ListNode.printListNode(list2);
    }

    @Test
    void rotateRight0() {
        int i = 0;
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.printListNode(list1);
        System.out.println("往后移动 " + i + " 位");
        ListNode list2 = solution.rotateRight(list1, i);
        ListNode.printListNode(list2);
    }

    @Test
    void rotateRight1() {
        int i = 1;
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.printListNode(list1);
        System.out.println("往后移动 " + i + " 位");
        ListNode list2 = solution.rotateRight(list1, i);
        ListNode.printListNode(list2);
    }

    @Test
    void rotateRight2() {
        int i = 2;
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.printListNode(list1);
        System.out.println("往后移动 " + i + " 位");
        ListNode list2 = solution.rotateRight(list1, i);
        ListNode.printListNode(list2);
    }


    @Test
    void rotateRight3() {
        int i = 3;
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.printListNode(list1);
        System.out.println("往后移动 " + i + " 位");
        ListNode list2 = solution.rotateRight(list1, i);
        ListNode.printListNode(list2);
    }

    @Test
    void rotateRight4() {
        int i = 4;
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.printListNode(list1);
        System.out.println("往后移动 " + i + " 位");
        ListNode list2 = solution.rotateRight(list1, i);
        ListNode.printListNode(list2);
    }

    @Test
    void rotateRight5() {
        int i = 5;
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.printListNode(list1);
        System.out.println("往后移动 " + i + " 位");
        ListNode list2 = solution.rotateRight(list1, i);
        ListNode.printListNode(list2);
    }

    @Test
    void rotateRight6() {
        int i = 6;
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        ListNode.printListNode(list1);
        System.out.println("往后移动 " + i + " 位");
        ListNode list2 = solution.rotateRight(list1, i);
        ListNode.printListNode(list2);
    }
}