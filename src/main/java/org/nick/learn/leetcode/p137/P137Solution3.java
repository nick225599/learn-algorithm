package org.nick.learn.leetcode.p137;

public class P137Solution3 {

    // 2ms 击败 45.87%
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int bitSum = 0;
            for (int num : nums) {
                int bitNum = (num << (31 - i)) >>> 31;
                bitSum += bitNum;
            }
            int bitVal = bitSum % 3;
            if (bitVal == 1) {
                ans += 1 << i;
            }
        }
        return ans;
    }

}
