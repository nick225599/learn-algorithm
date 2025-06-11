package org.nick.learn.leetcode.p206;

import org.nick.learn.algorithm.list.ListNode;

public class P206Solution4 {

    // 递归
    // 相比于迭代法，空间复杂度从 O(1) 上升到 O(n)
    public ListNode reverseList(ListNode node) {
        if (null == node || null == node.next) {
            return node;
        }

        ListNode tmp = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return tmp;

    }


}
