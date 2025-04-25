package org.nick.learn.leetcode.p28;

/**
 * 力扣 80. 删除有序数组中的重复项 II
 */
public class P28Solution2 {

    /**
     * 经过官方题解的点拨，用两个指针就行了，代码更清晰了
     */
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if(n <= 2){
            return n;
        }
        int slow = 1;
        for (int fast = 2; fast < n; fast++) {
            if (nums[fast] != nums[slow - 1]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }


}
