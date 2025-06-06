package org.nick.learn.algorithm.sort;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class QuickSortV2 {

    public static void main(String[] args) {

    }

    // 递推公示：quickSort(arr, l, r) = quickSort(arr, l, t), quickSort(arr, t + 1, r)

    // 结束条件：l <= r + 1
    public void sort(int[] array) {
        this.quickSort(array, 0, array.length - 1);
    }

    private void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int baseNum = arr[l];

        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] <= baseNum) {
                leftList.add(arr[i]);
            } else {
                rightList.add(arr[i]);
            }
        }

        List<Integer> resultList = new ArrayList<>();
        resultList.addAll(leftList);
        resultList.add(baseNum);
        resultList.addAll(rightList);

        for (int i = l, j = 0; i <= r && j < resultList.size(); i++, j++) {
            arr[i] = resultList.get(j);
        }
//        arr = resultList.stream().mapToInt(Integer::intValue).toArray();

        quickSort(arr, l, l + leftList.size() - 1);
        quickSort(arr, l + leftList.size() + 1, r);
    }


}


