package org.nick.learn.algorithm.sort;

import lombok.extern.slf4j.Slf4j;
import org.nick.learn.algorithm.utils.ArrayUtils;

@Slf4j
public class BubbleSort {

    public static void bubbleSort(int[] array) {
        for (int indexLast = array.length - 1; indexLast > 0; indexLast--) {
            boolean exchangeHappened = false;
            for (int i = 0; i < indexLast; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    exchangeHappened = true;
                }
            }
            if(!exchangeHappened){
                break;
            }
        }
    }

    // 冒泡排序，a表示数组，n表示数组大小
    public static void bubbleSortFromGeekTime(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j+1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }

    public static void main(String[] args) {
//        int length = 100;
//        int times;
//
//        times = 0;
//        for(int i = 0; i < length; i++){
//            times++;
//        }
//        log.info(" i++ 循环次数：" + times);
//
//        times = 0;
//        for(int i = 0; i < length; ++i){
//            times++;
//        }
//        log.info(" ++i 循环次数：" + times);
        long startTimeB = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            int[] array = ArrayUtils.generateIntArray(1000);
//            log.info("array: " + Arrays.toString(array));
            bubbleSortFromGeekTime(array, array.length);
//            log.info("array: " + Arrays.toString(array));
//            org.junit.jupiter.api.Assertions.assertTrue("array is asc.", ArrayUtils.arrayIsAsc(array));
//            System.out.println();
        }
        long endTimeB = System.currentTimeMillis();
        log.info("geek time: " + (endTimeB - startTimeB) + " ms");


        long startTimeA = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            int[] array = ArrayUtils.generateIntArray(1000);
//            log.info("array: " + Arrays.toString(array));
            bubbleSort(array);
//            log.info("array: " + Arrays.toString(array));
//            org.junit.jupiter.api.Assertions.assertTrue("array is asc.", ArrayUtils.arrayIsAsc(array));
//            System.out.println();
        }
        long endTimeA = System.currentTimeMillis();
        log.info("my time: " + (endTimeA - startTimeA) + " ms");

        //sunchuansheng 20240614 谁的代码放前面谁就慢
    }

}
