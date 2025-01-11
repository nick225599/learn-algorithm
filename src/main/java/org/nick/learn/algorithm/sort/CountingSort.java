package org.nick.learn.algorithm.sort;


public class CountingSort {



    public static void sort(int[] array, int n) {

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
