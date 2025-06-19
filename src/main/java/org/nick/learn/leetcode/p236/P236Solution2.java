package org.nick.learn.leetcode.p236;

import org.nick.learn.leetcode.p100.TreeNode;

import java.util.LinkedList;
import java.util.List;

public class P236Solution2 {



    // 进一步优化，同时匹配 p 和 q
    //TODO nick 怎么进行优化，保证每个节点只需要遍历一次？
    // todo 自己的判断结果由子节点的判断结果来保证
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root){
            return null;
        }

        // 左子树包含 p 或 q 且 右子树包含 p 或 q
        TreeNode left = lowestCommonAncestor(root.left, p, q); // 会重复遍历节点
        TreeNode right = lowestCommonAncestor(root.right, p, q); // 会重复遍历节点
        if(null != left && null != right){
            return root;
        }
        // 或
        // 当前节点等于 p 或 q 且 左子树或右子树包含 q 或 q
        //
        // 那么当前节点就是最深父节点
        boolean b1 = root.val == p.val || root.val == q.val;
        boolean b2 = null != left || null != right;
        if(b1 && b2){
            return root;
        }


        if(null != left){
            return left;
        }
        return right;
    }

}
