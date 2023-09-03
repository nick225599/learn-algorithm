package org.nick.learn.algorithm.aab_remove_element;

public class RemoveElementUtils {

    public static int removeElement(int[] nums, int val) {
        int resultLength = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                resultLength--;
                i--;
            }
        }
        return resultLength;
    }
}
