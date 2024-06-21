package org.nick.learn.algorithm.sort;

import org.junit.Assert;
import org.nick.learn.algorithm.common.ArrayUtils;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {
        int times = 6;

        long startTimeB = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            int[] array = ArrayUtils.generateIntArray(times);

            System.out.println("array: " + Arrays.toString(array));
            int countA = ArrayUtils.count(array);

            sort(array, array.length);

            System.out.println("array: " + Arrays.toString(array));
            int countB = ArrayUtils.count(array);
            Assert.assertTrue("array is asc.", ArrayUtils.arrayIsAsc(array));
            Assert.assertEquals(countA, countB);
            System.out.println();
        }
        long endTimeB = System.currentTimeMillis();
        System.out.println("geek time: " + (endTimeB - startTimeB) + " ms");
        System.out.println("-----------------------------------------------------------------------------------------");


//        int[] arr = {2, 0, 2};
//        int countA = ArrayUtils.count(arr);
//        System.out.println("array: " + Arrays.toString(arr));
//
//        sort(arr, arr.length);
//
//        int countB = ArrayUtils.count(arr);
//        System.out.println("array: " + Arrays.toString(arr));
//        Assert.assertEquals("排序前排序后的数据元素总和一致", countA, countB);
//        Assert.assertTrue("数组元素是升序的 ASC", ArrayUtils.arrayIsAsc(arr));
    }

    private static void sort(int[] array, int n) {

        // 1. 计算最大最小值
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < n; i++) {
            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }

        // 2. 计算桶数
        int numberOfBuckets = max - min + 1;

        // 3. 计算每个数应该装到哪个桶，并算出每个桶装多少个数
        int[] bucketIdx = new int[n];
        int[] buckets = new int[numberOfBuckets];
        for(int i = 0; i < n; i++){
            int idxOfBucket = array[i] - min;
            bucketIdx[i] = idxOfBucket;
            buckets[idxOfBucket]++;
        }

        // 4. 计算每个桶包括前面的桶累计共装多少个数
        int count = 0;
        for(int i = 0; i < numberOfBuckets; i++){
            count += buckets[i];
            buckets[i] = count;
        }

        // 5. 根据桶累计数，将数字重新摆放到新数组中
        int[] buff = new int[n];
        for(int i = 0; i<n;i++){
            buff[i] = array[i];
        }
        for(int i = 0; i < n; i++){
            int tmpIdx = buckets[bucketIdx[i]] - 1;
            array[tmpIdx] = buff[i];
            buckets[bucketIdx[i]] = --buckets[bucketIdx[i]];
        }
    }
}
