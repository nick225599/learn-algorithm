package org.nick.learn.leetcode.p373;

import java.util.List;

public class P373Solution3 {
    //作者：力扣官方题解
    //链接：https://leetcode.cn/problems/find-k-pairs-with-smallest-sums/solutions/1208350/cha-zhao-he-zui-xiao-de-kdui-shu-zi-by-l-z526/
    //来源：力扣（LeetCode）
    //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    //todo nick 20250730 写一下一般解法和非一般解法
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        // 如果我们每次都将已选的数对 (a
        //i
        //​
        // ,b
        //i
        //​
        // ) 的待选索引 (a
        //i
        //​
        // +1,b
        //i
        //​
        // ),(a
        //i
        //​
        // ,b
        //i
        //​
        // +1) 加入到堆中则可能出现重复的问题，一般需要设置标记位解决去重的问题。我们可以将 nums
        //1
        //​
        //  的前 k 个索引数对 (0,0),(1,0),…,(k−1,0) 加入到队列中，每次从队列中取出元素 (x,y) 时，我们只需要将 nums
        //2
        //​
        //  的索引增加即可，这样避免了重复加入元素的问题。
        //

    }


}
