package org.nick.learn.algorithm.sort;

import org.junit.Assert;
import org.nick.learn.algorithm.common.ArrayUtils;

import java.util.Arrays;

public class BubbleSort {

    public static int[] bubbleSort(int[] array) {
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
        return array;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            int[] array = ArrayUtils.generateIntArray(50);
            System.out.println("array: " + Arrays.toString(array));
            array = bubbleSort(array);
            System.out.println("array: " + Arrays.toString(array));
            Assert.assertTrue("array is asc.", ArrayUtils.arrayIsAsc(array));
            System.out.println();
        }
    }

}
