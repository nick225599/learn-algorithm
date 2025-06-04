package org.nick.learn.leetcode.p222;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class P222Solution2 {


    public int countNodes(TreeNode root) {
        // 1. 求出层数
        int level = 0;
        TreeNode tmpN = root;
        while (null != tmpN) {
            level++;
            tmpN = tmpN.left;
        }

        // 2. 二分求出最底层的缺失位置
        int min = 1 << (level - 1);
        int max = (1 << (level)) - 1;
        while (min < max) {
            int mid = min + (max - min + 1) >> 1;
            if (exist(root, level, mid)) {
                min = mid;
            } else {
                max = mid - 1;
            }
        }

        return min;

    }

    public boolean exist(TreeNode root, int level, int index) {
        index++;
        level-=2;
        TreeNode node = root;
        while (level > 0) {
            if ((index >> level) % 2 == 0) {
                node = node.left;
            } else {
                node = node.right;
            }
            level--;
        }
        return null == node;
    }


}
