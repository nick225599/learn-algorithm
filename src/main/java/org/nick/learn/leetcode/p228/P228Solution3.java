package org.nick.learn.leetcode.p228;

import java.util.ArrayList;
import java.util.List;

public class P228Solution3 {

    // 学习官方题解，处理逻辑只需要写一次
        public List<String> summaryRanges(int[] nums) {
            List<String> ret = new ArrayList<>();
            int n = nums.length;
            int i = 0;
            while(i < n){
                int low = i;
                i++;
                while(i < n && nums[i] == nums[i - 1] + 1){
                    i++;
                }
                int high = i - 1;
                StringBuilder sb = new StringBuilder();
                sb.append(nums[low]);
                if(low < high){
                    sb.append("->").append(nums[high]);
                }
                ret.add(sb.toString());
            }
            return ret;
        }

//    作者：力扣官方题解
//    链接：https://leetcode.cn/problems/summary-ranges/solutions/553645/hui-zong-qu-jian-by-leetcode-solution-6zrs/
//    来源：力扣（LeetCode）
//    著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


}
