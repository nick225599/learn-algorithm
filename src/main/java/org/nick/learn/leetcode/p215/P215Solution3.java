package org.nick.learn.leetcode.p215;

import java.util.PriorityQueue;

public class P215Solution3 {

    // 80ms 击败 16%
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(n);
        for(int num : nums){
            queue.add(num);
        }
        int i = 0;
        int ans = 0;
        while(i != n - k + 1){
            ans = queue.poll();
            i++;
        }
        return ans;
    }
}
