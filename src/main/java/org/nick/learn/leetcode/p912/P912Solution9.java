package org.nick.learn.leetcode.p912;

public class P912Solution9 {

    // 超时了
    public int[] sortArray(int[] nums) {
        this.quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = hoarePartition(nums, l, r);
            this.quickSort(nums, l, pos - 1);
            this.quickSort(nums, pos + 1, r);
        }
    }

    /**
     * 快排 hoare 分区法
     */
    public int hoarePartition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int i = l;
        int j = r;
        while (true) {
            while (i <= j && nums[i] <= pivot) {
                i++;
            }
            while (i <= j && nums[j] >= pivot) {
                j--;
            }
            if (i >= j) {
                break;
            }
            this.swap(nums, i, j);
            i++;
            j--;
        }
        this.swap(nums, l, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
