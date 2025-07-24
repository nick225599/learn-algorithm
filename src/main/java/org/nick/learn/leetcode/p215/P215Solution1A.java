package org.nick.learn.leetcode.p215;

public class P215Solution1A {

    // Lomuto 分区法（Lomuto's Partition Scheme）
    // 最右元素为轴
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length - 1, nums.length - k);
    }

    private int quickSort(int[] nums, int l, int r, int idx) {
        if (l == r) {
            return nums[idx];
        }
        int pos = lomutoPartition(nums, l, r);
        if (pos < idx) {
            return this.quickSort(nums, pos + 1, r, idx);
        } else if (idx < pos) {
            return this.quickSort(nums, l, pos - 1, idx);
        } else {
            return nums[idx];
        }
    }

    private int lomutoPartition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int j = l;
        for(int i = l; i < r; i++){
            if(nums[i] < pivot){
                this.swap(nums, i, j);
                j++;
            }
        }
        this.swap(nums, j, r);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }


}
