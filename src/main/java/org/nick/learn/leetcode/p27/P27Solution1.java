package org.nick.learn.leetcode.p27;

public class P27Solution1 {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = nums.length - 1; i <= j; ) {
            if (nums[i] == val) {
                nums[i] = nums[j--];
            } else {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        int count = new P27Solution1().removeElement(nums,val);
        System.out.println("count: " + count);
    }
}
