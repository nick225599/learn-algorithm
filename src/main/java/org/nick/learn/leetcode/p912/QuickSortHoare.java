package org.nick.learn.leetcode.p912;

public class QuickSortHoare {
    // 快速排序主方法
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // 进行分区操作，返回基准值最终位置
            int pivotPos = partition(arr, low, high);

            // 递归排序左右两部分
            quickSort(arr, low, pivotPos - 1);
            quickSort(arr, pivotPos + 1, high);
        }
    }

    // 分区方法：以[low+1, high]为检查区间，最后将基准值放到中间
    private static int partition(int[] arr, int low, int high) {
        // 选择第一个元素作为基准值
        int pivot = arr[low];
        int i = low;      // 左指针从low开始（最终会指向基准值的插入位置）
        int j = high;     // 右指针从high开始

        // 在[low+1, high]区间内进行分区
        while (i < j) {
            // 左指针向右移动：找到第一个大于基准值的元素
            while (i < j && arr[i + 1] <= pivot) {
                i++;
            }

            // 右指针向左移动：找到第一个小于基准值的元素
            while (arr[j] > pivot) {
                j--;
            }

            // 如果指针未交叉，交换元素
            if (i < j) {
                int temp = arr[i + 1];
                arr[i + 1] = arr[j];
                arr[j] = temp;
            }
        }

        // 将基准值放到分区中间（i的位置）
        arr[low] = arr[i];
        arr[i] = pivot;

        // 返回基准值的最终位置
        return i;
    }



    // 测试方法
    public static void main(String[] args) {
        int[] arr = {5,2,3,1};
        int n = arr.length;

        System.out.println("排序前的数组:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        quickSort(arr, 0, n - 1);

        System.out.println("\n排序后的数组:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
