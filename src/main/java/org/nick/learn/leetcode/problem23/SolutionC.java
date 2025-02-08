package org.nick.learn.leetcode.problem23;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.algorithm.list.ListNode;

/**
 * 力扣第 23 题
 */
@Slf4j
public class SolutionC {

    // 分治思维解题
    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || lists.length == 0) {
            return null;
        }

        if (lists.length > 2) {
            ListNode[] left = new ListNode[lists.length / 2];
            ListNode[] right = new ListNode[lists.length - lists.length / 2];
            for (int i = 0; i < lists.length; i++) {
                if (i < left.length) {
                    left[i] = lists[i];
                } else {
                    right[i - left.length] = lists[i];
                }
            }
            ListNode leftResult = mergeKLists(left);
            ListNode rightResult = mergeKLists(right);
            return mergeTwoListsV3(leftResult, rightResult);
        } else if (lists.length == 2) {
            return mergeTwoListsV3(lists[0], lists[1]);
        } else {
            return lists[0];
        }
        //TODO nick_sun 20250127 1. 再次分析一下时间复杂度和空间复杂度

        //TODO nick_sun 20250117 2， 是否可以使用循环来解决分治产生的栈帧空间使用，降低空间使用率？
    }


    /**
     * @deprecated 太绕了，应该参照官方题解，用一个头一个尾
     */
    @Deprecated
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        }

        l1 = new ListNode(-1, l1);
        l2 = new ListNode(-1, l2);

        ListNode result = l1.next;

        while (null != l1.next && null != l2.next) {
            if (l1.next.val > l2.next.val) {
                // l2.next 要从 l2 中移除，插入到 l1 中

                // 从 l2 中移除
                ListNode tmp = l2.next;
                l2.next = l2.next.next;

                // 从 l1 中插入
                ListNode tmp2 = l1.next;
                l1.next = tmp;
                tmp.next = tmp2;
            }
            l1 = l1.next;
        }

        if (null == l1.next) {
            l1.next = l2.next;
        }

        return result;
    }

    /**
     * @deprecated 比官方题解还是绕，继续尝试，不对 l1, l2 设置哨兵
     */
    @Deprecated
    public ListNode mergeTwoListsV2(ListNode l1, ListNode l2) {
        ListNode head, tail;
        head = tail = new ListNode(-1);
        l1 = new ListNode(-1, l1);
        l2 = new ListNode(-1, l2);
        while (null != l1.next && null != l2.next) {
            if (l1.next.val < l2.next.val) {
                // 从 l1 中剥离出节点
                // 将剥离出的节点，续到 tail 后面
                ListNode tmp = l1.next;
                l1.next = l1.next.next;
                tail.next = tmp;
            } else {
                ListNode tmp = l2.next;
                l2.next = l2.next.next;
                tail.next = tmp;
            }
            tail = tail.next;
        }
        tail.next = (null == l1.next) ? l2.next : l1.next;
        return head.next;
    }


    public ListNode mergeTwoListsV3(ListNode l1, ListNode l2) {
        ListNode head, tail;
        head = tail = new ListNode(0);
        while (null != l1 && null != l2) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next; // suncs 20250127 会影响到已经赋值给 tail.next 的 l1 吗？
                // 不会，tail.next 已经存储好了当时赋值给它的 l1 对象地址（地址值1）
                // 当 l1 的引用地址被 l1 = l1.next 改变后，l1 的确是变化了（地址值1 变成了 地址值2）
                // 但是之前赋值给 tail.next 的值依旧是地址值1，这个不会变化，变化的只有形参 l1 的值
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = null == l1 ? l2 : l1;
        return head.next;
    }
}
