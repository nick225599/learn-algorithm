package org.nick.learn.leetcode.p1;

import java.util.Arrays;

public class P1Solution1 {
    public int[] twoSum(int[] nums, int target) {
       int n = nums.length;
       for(int i= 0; i < n; i++){
           for(int j = i + 1; j < n; j++){
               if(nums[i] + nums[j] == target){
                   return new int[]{i, j};
               }
           }
       }
       return null;
    }

}
