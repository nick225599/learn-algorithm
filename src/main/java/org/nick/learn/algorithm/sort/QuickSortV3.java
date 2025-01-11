package org.nick.learn.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.nick.learn.algorithm.utils.ArrayUtils;

import java.util.Arrays;

@Slf4j
public class QuickSortV3 {

    public static void main(String[] args) {
        int times = 30;

        long startTimeB = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] array = ArrayUtils.generateIntArray(times);

            System.out.println("array: " + Arrays.toString(array));
            int countA = ArrayUtils.count(array);

            sort(array);

            System.out.println("array: " + Arrays.toString(array));
            int countB = ArrayUtils.count(array);
            Assert.assertTrue("array is asc.", ArrayUtils.arrayIsAsc(array));
            Assert.assertEquals(countA, countB);
            System.out.println();
        }
        long endTimeB = System.currentTimeMillis();
        System.out.println("geek time: " + (endTimeB - startTimeB) + " ms");
        System.out.println("-----------------------------------------------------------------------------------------");
//
//
//        int[] arr = new int[]{2, 1, 2};
//        int countA = ArrayUtils.count(arr);
//        System.out.println("array: " + Arrays.toString(arr));
//
//        sort(arr);
//
//        int countB = ArrayUtils.count(arr);
//        System.out.println("array: " + Arrays.toString(arr));
//        Assert.assertEquals("排序前排序后的数据元素总和一致", countA, countB);
//        Assert.assertTrue("数组元素是升序的 ASC", ArrayUtils.arrayIsAsc(arr));

    }

    // 递推公示：quickSort(arr, l, r) = quickSort(arr, l, t), quickSort(arr, t + 1, r)

    // 结束条件：l <= r + 1
    private static void sort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int baseNum = arr[r];

        int i = l;
        int j = l;
        for (; j < r; j++) {
            if (arr[j] < baseNum) {
                int tmp = arr[i];
                arr[i++] = arr[j];
                arr[j] = tmp;
            }
        }

        arr[j] = arr[i];
        arr[i] = baseNum;

        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }


}


