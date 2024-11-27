package org.nick.learn.algorithm.search;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BinarySearchSolution {

    public static int binarySearch(int[] arr, int target) {
        int startIndex = 0;
        int endIndex = arr.length - 1;
        while (startIndex < endIndex) {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            log.info("start index: {}, mid index: {}, end index: {}", startIndex, midIndex, endIndex);
            if (target < arr[midIndex]) {
                if(endIndex == midIndex){
                    break;
                }
                endIndex = midIndex;

            } else if (arr[midIndex] < target) {
                if(startIndex == midIndex){
                    break;
                }
                startIndex = midIndex;
            } else {
                return midIndex;
            }
        }
        if (arr[startIndex] == target) {
            return startIndex;
        } else {
            return -1;
        }
    }
}
