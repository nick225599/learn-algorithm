package org.nick.learn.leetcode.p35;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class P35Solution2 {
        public int searchInsert(int[] nums, int target) {
            int n = nums.length;
            int left = 0, right = n - 1, ans = n;
            while (left <= right) {
                int mid = ((right - left) >> 1) + left;
                if (target <= nums[mid]) {
                    ans = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return ans;
        }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/search-insert-position/solutions/333632/sou-suo-cha-ru-wei-zhi-by-leetcode-solution/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

}
