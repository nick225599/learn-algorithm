package org.nick.learn.leetcode.problem141;

/**
 * 怎么在空间复杂度 O(1) 下完成检查？
 * 完成了，
 * 但改变了 ListNode ，能在不改变的情况下处理吗？
 */
public class SolutionB {

    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }

        head.val += 200001;
        while ((head = head.next) != null) {
            if (head.val < 100000) {
                head.val += 200001;
            } else {
                return true;
            }
        }
        return false;
    }
}
