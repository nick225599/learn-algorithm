package org.nick.learn.algorithm.sort;


public class SelectionSort {
    public  void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++){
            int baseNum = arr[i];
            int minIndex = i;
            int j;
            for(j = i + 1; j < arr.length; j++){
                if(baseNum > arr[j]){
                    baseNum = arr[j];
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {

 }
}
