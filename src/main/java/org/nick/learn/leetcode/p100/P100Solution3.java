package org.nick.learn.leetcode.p100;

import java.util.LinkedList;
import java.util.Queue;

public class P100Solution3 {

    // 广度优先
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.add(p);
        qQueue.add(q);
        TreeNode tmpP;
        TreeNode tmpQ;
        while ((tmpP = pQueue.poll()) != null) {
            tmpQ = qQueue.poll();

            if (null == tmpQ) {
                return false;
            } else if (tmpP.val != tmpQ.val) {
                return false;
            } else if (tmpP.left == null ^ tmpQ.left == null) {
                return false;
            } else if (tmpP.right == null ^ tmpQ.right == null) {
                return false;
            }
            if (null != tmpP.left) {
                pQueue.add(tmpP.left);
                qQueue.add(tmpQ.left);
            }
            if (null != tmpP.right) {
                pQueue.add(tmpP.right);
                qQueue.add(tmpQ.right);
            }

        }
        return (tmpQ = qQueue.poll()) == null && qQueue.isEmpty();
    }
}
