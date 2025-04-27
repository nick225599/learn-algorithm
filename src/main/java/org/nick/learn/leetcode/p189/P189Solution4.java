package org.nick.learn.leetcode.p189;

/**
 * 力扣 189. 轮转数组
 */
public class P189Solution4 {

    /**
     * 三次翻转法
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n <= 1) {
            return;
        }

        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while(i < j){
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }


}
