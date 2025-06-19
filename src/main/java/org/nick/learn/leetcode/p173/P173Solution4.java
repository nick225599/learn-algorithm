package org.nick.learn.leetcode.p173;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.leetcode.p100.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

@Slf4j
public class P173Solution4 {
    // in-order: left, val, right
    // 进阶：
    //
    //你可以设计一个满足下述条件的解决方案吗？
    // next() 和 hasNext() 操作均摊时间复杂度为 O(1) ，
    // 并使用 O(h) 内存。其中 h 是树的高度。
    //
    // 写不出来
    public static class BSTIterator {
        private TreeNode cur;
        private Deque<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new LinkedList<>();
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int ret = cur.val;
            cur = cur.right;
            return ret;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/binary-search-tree-iterator/solutions/683126/er-cha-sou-suo-shu-die-dai-qi-by-leetcod-4y0y/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
}
