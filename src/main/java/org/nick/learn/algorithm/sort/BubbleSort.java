package org.nick.learn.algorithm.sort;

import org.junit.Assert;
import org.nick.learn.algorithm.common.ArrayUtils;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int[] array) {

        // 脑子没想清楚瞎写的第一版
//        for (int j = 0; j < array.length; j++) {
//            for (int i = j; i < array.length - 1; i++) {
//                int l = array[i];
//                int r = array[i + 1];
//                if (l > r) {
//                    array[i] = r;
//                    array[i + 1] = l;
//                }
//            }
//        }

        // 脑子想了一想的第一版
//        for(int indexLast = array.length - 1; indexLast <= 1; indexLast -- ){
//            for(int i = 0; i < indexLast; i++){
//                int left = array[i];
//                int right = array[i + 1];
//                if(left > right){
//                    array[i] = right;
//                    array[i + 1] = left;
//                }
//            }
//        }

        // 脑子想了一想的第二版
//        for (int indexLast = array.length - 1; indexLast >= 0; indexLast--) {
//            for (int i = 0; i <= indexLast; i++) {
//                int left = array[i];
//                int right = array[i + 1];
//                if (left > right) {
//                    array[i] = right;
//                    array[i + 1] = left;
//                }
//            }
//        }

        // 第二版报错了，改成第三版
        for (int indexLast = array.length - 1; indexLast > 0; indexLast--) {
            for (int i = 0; i < indexLast; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int[] array = ArrayUtils.generateIntArray(10);
            System.out.println("array: " + Arrays.toString(array));
            array = bubbleSort(array);
            System.out.println("array: " + Arrays.toString(array));
            Assert.assertTrue("array is asc.", ArrayUtils.arrayIsAsc(array));
            System.out.println();
        }
    }

}
