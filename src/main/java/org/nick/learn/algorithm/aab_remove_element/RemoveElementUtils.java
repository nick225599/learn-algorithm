package org.nick.learn.algorithm.aab_remove_element;

public class RemoveElementUtils {

    public static int removeElement(Integer[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != null && nums[i] == val) {
                for (int j = i; j < nums.length; j++) {
                    if (j < nums.length - 1) {
                        nums[j] = nums[j + 1];
                    } else {
                        nums[j] = null;
                    }
                }
            }
        }
        return nums.length;
    }
}
