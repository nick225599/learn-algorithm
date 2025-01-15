package org.nick.learn.leetcode.problem169;


public class SolutionB {
    public int majorityElement(int[] nums) {
        // 堆排序 + 取中间数
        this.heapSort(nums);
        return nums[nums.length / 2];
        //TODO sunchuansheng 怎么实现堆排序？
        //TODO sunchuansheng 随机法(2次尝试) + 分治法
        //TODO sunchuansheng Boyer-Moore投票算法 算法
    }

    public void heapSort(int[] arr) {
        // 建大顶堆
        this.heapify(arr, arr.length);

        for (int i = arr.length - 1; i >= 0; i--) {

            // 将第 0 位的最大值交换到最后面
            swap(arr, 0, i);

            // 重新建大顶堆
            this.heapify(arr, i);
        }

    }

    private void heapify(int[] arr, int length) {
        for (int i = length / 2 - 1; i >= 0; i--) {
            while (true) {
                int max = i;

                int leftNode = i * 2 + 1;
                if (leftNode < length && arr[leftNode] > arr[max]) {
                    max = leftNode;
                }

                int rightNode = leftNode + 1;
                if (rightNode < length && arr[rightNode] > arr[max]) {
                    max = rightNode;
                }

                if (i == max) {
                    break;
                } else {
                    swap(arr, i, max);
                    i = max;
                }
            }
        }

    }
    public static void swap(int[] arr, int l, int r) {
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }
}
