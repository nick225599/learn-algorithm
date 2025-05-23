package org.nick.learn.leetcode.p219;

public class P219Solution1 {
    // 时间复杂度 O(n^2)
    // 空间复杂度 O(1)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(nums[i] == nums[j] && j - i <= k){
                    return true;
                }
            }
        }
        return false;
    }
}
