package org.nick.learn.leetcode.p26;

public class P26Solution1 {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }

        int fast = 1, slow = 0;
        for(; fast < nums.length; fast++){
            if(nums[slow] != nums[fast]){
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}
