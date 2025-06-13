package org.nick.learn.leetcode.p82;

import org.nick.learn.algorithm.list.ListNode;

public class P82Solution1 {

    // head =
    //[1,2,3,3,4,4,5]
    //输出
    //[1,2,3,4,5]
    //预期结果
    //[1,2,5]
    public ListNode deleteDuplicates(ListNode head) {
//        if (null == head || null == head.next) {
//            return head;
//        }
//        ListNode pre = head;
//        ListNode cur = pre.next;
//        while (pre.val == cur.val) {
//            ListNode succ = cur.next;
//            if (null == succ) {
//                return null;
//            }
//            while (null != succ && cur.val == succ.val) {
//                succ = succ.next;
//            }
//            pre = succ;
//            if (null != pre) {
//                cur = pre.next;
//            } else {
//                cur = null;
//            }
//        }
        // * 先确认 pre cur 是否是值相同
        //  * 如果 pre cur 位值相同
        //   * 往后找与 cur 值不同的 succ
        //    * 找得到，则 pre = succ, cur = succ.next;
        //      * 重新判断 pre cur 值是否相同
        //    * 找不到，则直接返回 null
        //
        //  * 如果 pre cur 值不同，则评估 pre cur 位值是否相同
        return null;
    }
}
