package temp;

import java.util.Arrays;
import java.util.Random;

/**
 * 二分查找是不是压栈能出现栈溢出？
 */
public class Temp001 {

    public static void main(String[] args) {
        int[] nums = generateIntArray(1024102410);
//        System.out.println("nums[] : " + Arrays.toString(nums));
        int max = binarySearchMax(nums);
        System.out.println("max in nums[]: " + max);
    }

    private static int[] generateIntArray(int length) {
        int[] temp = new int[length];
        Random r = new Random(System.currentTimeMillis());
        for(int i = 0; i < length; i++){
            temp[i] = r.nextInt();
        }
        return temp;
    }

    private static int binarySearchMax(int[] nums) {
        return binarySearchMax(nums, 0, nums.length - 1);
    }

    private static int binarySearchMax(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        } else {
            int mid = left + ((right - left) >> 1);
            int tempA = binarySearchMax(nums, left, mid);
            int tempB = binarySearchMax(nums, mid + 1, right);
            if (tempA > tempB) {
                return tempA;
            } else {
                return tempB;
            }
        }
    }

}
