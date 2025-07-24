package org.nick.learn.leetcode.p912;

public class P912Solution2 {
    public int[] sortArray(int[] nums) {
        this.quicksort(nums, 0, nums.length - 1);
        return nums;
    }

    // 三元取中
    private void quicksort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        this.medianOfThree(nums, l, r);
        int i = l;
        int target = nums[l];
        for (int k = i + 1; k <= r; k++) {
            if (nums[k] < target) {
                this.swap(nums, k, i);
                i++;
            }
        }
        if (i != l) {
            swap(nums, i, r);
        }
        // 怎么提前结束，避免无限递归死循环？
        this.quicksort(nums, l, i - 1);
        if (i == l) {
            this.quicksort(nums, i + 1, r);
        } else {
            this.quicksort(nums, i, r);
        }
    }

    private void medianOfThree(int[] nums, int l, int r) {
        int i1 = nums[l];
        int i2 = nums[l + ((r - l) >> 1)];
        int i3 = nums[r];
        if ((i1 <= i2 & i2 <= i3) || (i3 <= i2 && i2 <= i1)) {
            this.swap(nums, l, l + ((r - l) >> 1));
        } else if ((i2 <= i1 && i1 <= i3) || (i3 <= i1 && i1 <= i2)) {

        } else {
            this.swap(nums, l, r);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
