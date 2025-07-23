package org.nick.learn.leetcode.p153;

public class P153Solution2 {

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/find-minimum-in-rotated-sorted-array/solutions/698479/xun-zhao-xuan-zhuan-pai-xu-shu-zu-zhong-5irwp/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
        public int findMin(int[] nums) {
            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                int pivot = low + (high - low) / 2;
                if (nums[pivot] < nums[high]) {
                    // [mid, right] 是升区间
                    // 那么要么整个 [left, right] 都是升区间
                    // 要么断裂带在 [left, mid] 中
                    high = pivot; // 如果 high = pivot - 1， 则处理不好 [3, 1, 2] 这一组合
                } else {
                    low = pivot + 1; // 小心翼翼缩小范围
                    // nick 这难道不会退化成 O(n) ?
                    // 不会，但感觉没有我的 Solution1 解法效率高，我直接缩到中间点
                }
            }
            return nums[low];
        }

        // 后记： 二分查找法怎么这么多变种啊？ 嗷 不对，是各种题型怪怪的

}
