package org.nick.learn.leetcode.p215;

public class P215Solution2 {

    // 作者：力扣官方题解
    // 链接：https://leetcode.cn/problems/kth-largest-element-in-an-array/solutions/307351/shu-zu-zhong-de-di-kge-zui-da-yuan-su-by-leetcod-2/
    // 来源：力扣（LeetCode）
    // 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return quickselect(nums, 0, n - 1, n - k);
    }

    // 双指针快排
//    Hoare 分区法（Hoare's Partition Scheme）
    int quickselect(int[] nums, int l, int r, int k) {
        if (l == r) return nums[k];
        int x = nums[l], i = l - 1, j = r + 1;
        while (i < j) {
            do {
                i++;
            } while (nums[i] < x);

            do {
                j--;
            } while (nums[j] > x);

            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }
        if (k <= j) {
            return quickselect(nums, l, j, k);
        } else {
            return quickselect(nums, j + 1, r, k);
        }
    }


}
