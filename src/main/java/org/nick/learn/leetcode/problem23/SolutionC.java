package org.nick.learn.leetcode.problem23;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.algorithm.list.ListNode;

/**
 * 力扣第 23 题
 */
@Slf4j
public class SolutionC {
    public ListNode mergeKLists(ListNode[] lists) {
        //TODO nick_sun 20250117 使用分治思想解决问题
        //TODO nick_sun 20250117 是否可以使用循环来解决分治产生的栈帧空间使用，降低空间使用率？
        return null;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        }

        l1 = new ListNode(-1, l1);
        l2 = new ListNode(-1, l2);

        ListNode result = l1.next;

        while(null != l1.next && null != l2.next){
            if(l1.next.val > l2.next.val){
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

        if(null == l1.next){
            l1.next = l2.next;
        }

        return result;
    }
}
