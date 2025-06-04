package org.nick.learn.leetcode.p108;

import org.nick.learn.leetcode.p100.TreeNode;

public class P108Solution1 {

    // 中序遍历
    // 时间复杂度 O(n)
    // 空间复杂度 O(logn)
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int startIndex, int endIndex) {
        if(startIndex > endIndex){
            return null;
        }

        int mid = ((endIndex - startIndex) >> 1) + startIndex;

        return new TreeNode(nums[mid],
                sortedArrayToBST(nums, startIndex, mid - 1),
                sortedArrayToBST(nums, mid + 1, endIndex));
    }

}
