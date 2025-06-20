package org.nick.learn.leetcode.p236;

import org.nick.learn.leetcode.p100.TreeNode;

public class P236Solution2 {

    TreeNode result;


    // 进一步优化，同时匹配 p 和 q
    //TODO nick 怎么进行优化，保证每个节点只需要遍历一次？
    // todo 自己的判断结果由子节点的判断结果来保证


    /**
     * @return p 和 q 在 root 二叉树中的最深公共父节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root) {
            return null;
        }

        this.dfs(root, p, q);

        return result;


//        boolean b1 = this.dfs(root.left, p, q); // 会重复遍历节点
//        boolean b2 = this.dfs(root.right, p, q); // 会重复遍历节点
//
//        // 左子树包含 p 或 q 且 右子树包含 p 或 q
//        // 或
//        // 当前节点等于 p 或 q 且 左子树或右子树包含 q 或 q
//        //
//        // 那么当前节点就是最深父节点
//        if(
//                (b1 && b2)
//        || (b1 || b2) && (root.val == p.val || root.val == q.val)
//        ){
//            return root;
//        }
    }

    /**
     * @return p 或 q 是否在 node 为根节点的二叉树中
     */
    private boolean dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return false;
        }
        boolean b1 = this.dfs(node.left, p, q); // 会重复遍历节点
        boolean b2 = this.dfs(node.right, p, q); // 会重复遍历节点

        // 左子树包含 p 或 q 且 右子树包含 p 或 q
        // 或
        // 当前节点等于 p 或 q 且 左子树或右子树包含 q 或 q
        //
        // 那么当前节点就是最深父节点
        if (
                (b1 && b2)
                        || (b1 || b2) && (node.val == p.val || node.val == q.val)
        ) {
            result = node;
        }

        return b1 || b2 || node.val == p.val || node.val == q.val;
    }

}
