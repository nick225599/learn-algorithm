package org.nick.learn.leetcode.p912;

public class P912Solution9 {

    // 1660ms 击败 23.35%
    public int[] sortArray(int[] nums) {
        this.quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r) {
        if (l < r) {
            int pos = hoareParitition(nums, l, r);
            this.quickSort(nums, l, pos - 1);
            this.quickSort(nums, pos + 1, r);
        }
    }

    /**
     * 快排 hoare 分区法
     */
    private int hoareParitition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int i = l;
        int j = r + 1;
        while (true) {
            // 从左往右找到第一个大于 pivot 的数的下标
            do {
                i++;

                //TODO 处理越界问题？
                // 比如 [3, 1, 2, 3]
                // i 递增到了 4
                // 再进行 nums[i] < pivot 时越界了
                if(i > r){
                    break;
                }

            } while (nums[i] < pivot);


            // 从右往左找到第一个小于 pivot 的数的下标
            do {
                j--;
                if(j < l + 1){
                    break;
                }
            } while (nums[j] > pivot);

            if (i < j) {
                this.swap(nums, i, j);
            } else {
                break;
            }

        }
        if (l != j) {
            this.swap(nums, l, j);
        }
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
